package com.jf.crawl;

import java.util.ArrayList;
import java.util.List;

import com.jf.crawl.connect.DecoderType;
import com.jf.crawl.connect.NettyServer;
import com.jf.crawl.demo.PeopleMessageHandler;

import io.netty.channel.ChannelHandler;

/**
 * 启动服务端，暴露端口
 * @author lamen 2019/8/12
 */
public class TestServer {

	public static void main(String[] args) {
		// 添加业务实现类
		List<ChannelHandler> handlerList = new ArrayList<>();
		handlerList.add(new PeopleMessageHandler());
		
		Integer[] ports = { 6021 };
		for (Integer port : ports) {
			NettyServer.build(handlerList, DecoderType.CUSTOM).port(port).open();
		}
	}
}
