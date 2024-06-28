package com.tw.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Tian
 * @desc
 * @since 2022/1/16 14:22
 *
 * java.util.regex 包主要包括以下三个类：
 *
 *  Pattern 类：
 *  pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
 *
 *  Matcher 类：
 *  Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
 *
 *  PatternSyntaxException：
 *  PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
 *
 */
public class regexDemo {

    @Test
    public void test() {
        // 写法1
        String content = "I am noob " + "from runoob.com.";
        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);

        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    /**
     * 捕获组的特征：
     *       1、用（）括起来的单元称之为捕获组；
     *       2、在正则表达式中，会对捕获组进行自动编号，编号从1开始。这与大多数的编号从0开始不同。
     *       3、\n表示引用编号为n的捕获组；
     *       4、捕获组的编号从（左括号的出现位置开始依次计数。
     *       5 还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
     */
    @Test
    public void test2() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String line2 = "01a1a";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line2);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

    /**
     * 不同括号：
     * 正则表达式的() [] {}有不同的意思。
     * 1 () 是为了提取匹配的字符串。表达式中有几个()就有几个相应的匹配字符串。
     * 2 (\s*)表示连续空格的字符串。
     * 3 []是定义匹配的字符范围。比如 [a-zA-Z0-9] 表示相应位置的字符要匹配英文字符和数字。[\s*]表示空格或者*号。
     * 4 {}一般用来表示匹配的长度，比如 \s{3} 表示匹配三个空格，\s[1,3]表示匹配一到三个空格。
     * 5 (0-9) 匹配 '0-9′ 本身。 [0-9]* 匹配数字(注意后面有 *，可以为空)[0-9]+ 匹配数字(注意后面有 +，不可以为空){1-9} 写法错误。
     * 6 [0-9]{0,9} 表示长度为 0 到 9 的数字字符串。
     *
     * 原文链接：https://blog.csdn.net/weixin_34270705/article/details/114168431
     *
     *
     * \w
     * 匹配包括下划线的任何单词字符。类似但不等价于“[A-Za-z0-9_]”，这里的"单词"字符使用Unicode字符集。
     * \W
     * 匹配任何非单词字符。等价于“[^A-Za-z0-9_]”。
     * \s
     * 匹配任何不可见字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。
     * \S
     * 匹配任何可见字符。等价于[^ \f\n\r\t\v]。
     * 原文链接：https://blog.csdn.net/weixin_35843812/article/details/114346694
     *
     * ?
     * 当该字符紧跟在任何一个其他限制符(*,+,?，{n}，{n,}，{n,m})后面时，匹配模式是非贪婪的。
     * 非贪婪模式尽可能少的匹配所搜索的字符串，而默认的贪婪模式则尽可能多的匹配所搜索的字符串。
     * 例如，对于字符串“oooo”，“o+?”将匹配单个“o”，而“o+”将匹配所有“o”。
     * 原文链接：https://blog.csdn.net/weixin_35843812/article/details/114346694
     *
     */
    @Test
    public void test3() {

        // 写法2
        String str = "tianwei0629@126.com";

        Pattern REGEX_PATTERN = Pattern.compile("\\s*([\"]?[\\w]+[\"]?)(\\s*[:=]+[^\\u4e00-\\u9fa5@,.*{\\[\\w]*\\s*)([\\u4e00-\\u9fa5_\\-@.\\w]+)[\\W&&[^\\-@.]]?\\s*");
        Matcher regexMatcher = REGEX_PATTERN.matcher(str);
        String key = regexMatcher.group(1).replaceAll("\"", "").trim();
        System.out.println("======>"+key);
    }

    @Test
    public void test4() {
        String line = ",aa,bcd,eef,,,";
        String line2 = "tianwei0629@126@.com";
        //String[] split = line2.split("@",2);

        String splitChar = "(?=" + "@" + ")";
        String[] split = line2.split(splitChar,2);
        System.out.println(split.length);//2
        for(int i=0; i<split.length; i++){
            System.out.println(split[i]);
        }
    }


    /**
     * 统计单词 "cat"的个数, 前后不能有其他字符,除了空格
     */
    @Test
    public void test5() {
        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while(m.find()) {
            String s = INPUT;
            count++;
            System.out.println("Match number "+count);
            System.out.println("开始: "+m.start() + " 结束: "+m.end());
            String sub = s.substring(m.start(),m.end());
            System.out.println("sub: "+sub + " size:" + sub.length());
            System.out.println("");
        }
    }

    @Test
    public void test6() {

        String emailSubject = "中租对账流水";
        if (Pattern.matches(emailSubject, "中租对账流水20220728") ){
            System.out.println("match");
        }else {
            System.out.println("not match");
        }
    }
}
