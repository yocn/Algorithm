package okio;

import util.LogUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by yocn on 2019/2/20.
 */
public class testOKIO {
    public static void test() {
        File srcFile = new File("src.txt");
        File destFile = new File("dest.txt");
//        readSimpleString(file);
//        testByteString();
        copySingleText(srcFile, destFile);
    }

    private static void readSimpleString(File file) {
        try {
            Source source = Okio.source(file);
            BufferedSource bufferedSource = Okio.buffer(source);
//            String read = bufferedSource.readString(Charset.forName("utf-8"));
//            LogUtil.Companion.d("read->" + read);
            byte[] sink = new byte[2014];
            bufferedSource.read(sink);
            for (byte b : sink) {
                LogUtil.Companion.d("b->" + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testByteString() {
        byte[] bytes = new byte[]{'a', 'a'};
        ByteString bs = new ByteString(bytes);
        LogUtil.Companion.d("bs->" + bs.utf8() + " " + bs.base64());
    }

    private static void copySingleText(File srcFile, File destFile) {
        if (srcFile == null || !srcFile.exists()) {
            return;
        }
        if (destFile == null) {
            return;
        }
        if (!destFile.exists()) {
            try {
                boolean isSuccess = destFile.createNewFile();
                LogUtil.Companion.d("isSuccess->" + isSuccess);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedSink sink = null;
        try {
            byte[] src = Okio.buffer(Okio.source(srcFile)).readByteArray();
            sink = Okio.buffer(Okio.sink(destFile));
            for (int i = 0; i < src.length; i++) {
                if (i % 4 == 0 || i % 4 == 1) {
                    sink.writeByte(src[i]);
                    LogUtil.Companion.d("src[i]->" + src[i]);
                } else {
                    LogUtil.Companion.d("drop->" + src[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sink.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
