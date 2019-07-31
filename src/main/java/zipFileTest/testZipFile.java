package zipFileTest;

import util.LogUtil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by yocn on 2019/7/31.
 * 测试zip文件
 */
public class testZipFile {
    public void test() {

        String path = "/Users/yocn/Desktop/app.apk";
        try {
            File file = new File(path);
            long time1 = System.currentTimeMillis();
            boolean isZipFile = isZipFile(file);
            write2Zip(file, "abc_yocn");
            String ss = getZipTail(file);
            LogUtil.Companion.d("ss->" + ss);
            long time2 = System.currentTimeMillis();
            LogUtil.Companion.d("是否是zip->" + isZipFile + " " + (time2 - time1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //magic -> yocn
    private static final byte[] MAGIC = new byte[]{0x79, 0x6F, 0x63, 0x6E};
    //没有zip文件注释时候的目录结束符的偏移量
    private static final int RawEndOffset = 22;
    //0x06054b50占4个字节
    private static final int endOfDirLength = 4;
    //目录结束标识0x06054b50 的小端读取方式。
    private static final byte[] endOfDir = new byte[]{0x50, 0x4B, 0x05, 0x06};
    //注释长度占两个字节，所以理论上可以支持 2^16 个字节。
    private static final int commentLengthBytes = 2;
    //注释长度
    private static final int commentLength = 8;


    private boolean isZipFile(File file) throws IOException {
        if (file.exists() && file.isFile()) {
            if (file.length() <= RawEndOffset + endOfDirLength) {
                return false;
            }
            long fileLength = file.length();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            //seek到结束标记所在的位置
            randomAccessFile.seek(fileLength - RawEndOffset);
            byte[] end = new byte[endOfDirLength];
            //读取4个字节
            randomAccessFile.read(end);
            //关掉文件
            randomAccessFile.close();
            return isEndOfDir(end);
        } else {
            return false;
        }
    }

    /**
     * 是否符合文件夹结束标记
     */
    private boolean isEndOfDir(byte[] src) {
        if (src.length != endOfDirLength) {
            return false;
        }
        for (int i = 0; i < src.length; i++) {
            if (src[i] != endOfDir[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * zip(apk)尾追加渠道信息
     */
    private void write2Zip(File file, String channelInfo) throws IOException {
        if (isZipFile(file)) {
            long fileLength = file.length();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            //seek到结束标记所在的位置
            randomAccessFile.seek(fileLength - commentLengthBytes);
            byte[] lengthBytes = new byte[2];
            lengthBytes[0] = commentLength;
            lengthBytes[1] = 0;
            randomAccessFile.write(lengthBytes);
            randomAccessFile.write(getChannel(channelInfo));
            randomAccessFile.close();
        }
    }

    /**
     * 获取zip(apk)文件结尾
     *
     * @param file 目标哦文件
     */
    private String getZipTail(File file) throws IOException {
        long fileLength = file.length();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        //seek到magic的位置
        randomAccessFile.seek(fileLength - MAGIC.length);
        byte[] magicBytes = new byte[MAGIC.length];
        //读取magic
        randomAccessFile.read(magicBytes);
        //如果不是magic结尾，返回空
        if (!isMagicEnd(magicBytes)) return "";
        //seek到读到信息的offest
        randomAccessFile.seek(fileLength - commentLength);
        byte[] lengthBytes = new byte[commentLength];
        //读取渠道
        randomAccessFile.read(lengthBytes);
        randomAccessFile.close();
        char[] lengthChars = new char[commentLength];
        for (int i = 0; i < commentLength; i++) {
            lengthChars[i] = (char) lengthBytes[i];
        }
        return String.valueOf(lengthChars);
    }

    /**
     * 是否以魔数结尾
     *
     * @param end 检测的byte数组
     * @return 是否结尾
     */
    private boolean isMagicEnd(byte[] end) {
        for (int i = 0; i < end.length; i++) {
            if (MAGIC[i] != end[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成渠道byte数组
     */
    private byte[] getChannel(String s) {
        byte[] src = s.getBytes();
        byte[] channelBytes = new byte[commentLength];
        System.arraycopy(src, 0, channelBytes, 0, commentLength);
        return channelBytes;
    }

}
