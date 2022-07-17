
#如何优雅处理重复请求/并发请求？
https://mp.weixin.qq.com/s/Mq5cAFMYoJyGjaGJrnXXuA


================================================
Run: com.tw.encrypt.md5.Md5Demo.main

console:
10:57:21.928 [main] DEBUG com.tw.encrypt.md5.ReqDedupHelper - md5deDupParam = 9E054D36439EBDD0604C5E65EB5C8267, excludeKeys = [] {"requestKey":"key","requestTime":"20190101120001","requestValue":"1000"}
10:57:21.935 [main] DEBUG com.tw.encrypt.md5.ReqDedupHelper - md5deDupParam = A2D20BAC78551C4CA09BEF97FE468A3F, excludeKeys = [] {"requestKey":"key","requestTime":"20190101120002","requestValue":"1000"}
req1MD5 = 9E054D36439EBDD0604C5E65EB5C8267 , req2MD5=A2D20BAC78551C4CA09BEF97FE468A3F
10:57:21.936 [main] DEBUG com.tw.encrypt.md5.ReqDedupHelper - md5deDupParam = C2A36FED15128E9E878583CAAAFEFDE9, excludeKeys = [requestTime] {"requestKey":"key","requestValue":"1000"}
10:57:21.936 [main] DEBUG com.tw.encrypt.md5.ReqDedupHelper - md5deDupParam = C2A36FED15128E9E878583CAAAFEFDE9, excludeKeys = [requestTime] {"requestKey":"key","requestValue":"1000"}
req1MD5 = C2A36FED15128E9E878583CAAAFEFDE9 , req2MD5=C2A36FED15128E9E878583CAAAFEFDE9
================================================

日志说明：
一开始两个参数由于 requestTime 是不同的，所以求去重参数摘要的时候可以发现两个值是不一样的；
第二次调用的时候，去除了 requestTime 再求摘要（第二个参数中传入了”requestTime”），则发现两个摘要是一样的，符合预期。

