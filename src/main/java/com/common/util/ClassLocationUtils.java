package com.common.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * @author David Tian
 * @since 2019-03-14
 *
 * 查看运行期类来源的JAR包
 *
 * 有时，你以为解决了，但是偏偏还是报类包冲突（典型症状是java.lang.ClassNotFoundException或Method不兼容等异常），
 * 这时你可以设置一个断点，在断点处通过下面这个我做的工具类来查看Class所来源的JAR包.
 *
 * 随便写一个测试，设置好断点，在执行到断点处按alt+F8动态执行代码（intelij idea），假设我们输入：
 * Java代码  收藏代码
 *
 * ClassLocationUtils.where(org.objectweb.asm.ClassVisitor.class)
 * 即可马上查出类对应的JAR了.
 *
 * 其实都是IDE的缓存造成的了
 * idea清除缓存,为了提高效率不建议采用reimport重新起开启项目的方式,建议采用idea自带的功能,File->Invalidate Caches 功能直接完成清除idea cache
 *
 *
 *
 */
public class ClassLocationUtils {

    /**
     * 获取类所有的路径
     * @param cls
     * @return
     */
    public static String where(final Class cls) {
        if (cls == null){
            throw new IllegalArgumentException("null input: cls");
        }
        URL result = null;
        final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
        final ProtectionDomain pd = cls.getProtectionDomain();
        if (pd != null) {
            final CodeSource cs = pd.getCodeSource();
            if (cs != null){
                result = cs.getLocation();
            }
            if (result != null) {
                if ("file".equals(result.getProtocol())) {
                    try {
                        if (result.toExternalForm().endsWith(".jar") ||
                                result.toExternalForm().endsWith(".zip")){
                            result = new URL("jar:".concat(result.toExternalForm())
                                    .concat("!/").concat(clsAsResource));
                        }
                        else if (new File(result.getFile()).isDirectory()) {
                            result = new URL(result, clsAsResource);
                        }
                    }
                    catch (MalformedURLException ignore) {}
                }
            }
        }
        if (result == null) {
            final ClassLoader clsLoader = cls.getClassLoader();
            result = clsLoader != null ?
                    clsLoader.getResource(clsAsResource) :
                    ClassLoader.getSystemResource(clsAsResource);
        }
        return result.toString();
    }

}