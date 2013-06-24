功能描述：内存占用测试

1.打成jar包后在MANIFEST.MF中添加
	Premain-Class: eu.plumbr.sizeof.MemoryCounterAgent
2.启动脚本 -javaagent:./lib/sizeofagent2.jar -cp ./lib/sizeofagent2.jar;./lib......	
