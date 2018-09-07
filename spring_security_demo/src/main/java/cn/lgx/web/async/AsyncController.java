/**
 *
 */
package cn.lgx.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;


@RestController
public class AsyncController {

	@Autowired
	private MockQueue mockQueue;

	@Autowired
	private DeferredResultHolder deferredResultHolder;

	private Logger logger = LoggerFactory.getLogger(getClass());

//	同步
//	@RequestMapping("/order")
//	public String order() throws Exception {
//		logger.info("主线程开始");
//		Thread.sleep(1000);
//		logger.info("主线程返回");
//		return "success";
//	}

//	异步 tomacat的主执行不受影响，可以提高服务器的吞吐量
//	runnable的异步处理请求受 主线程 控制
//	@RequestMapping("/order")
//	public 	Callable<String> order() throws Exception {
//
//		logger.info("主线程开始");
//
//		Callable<String> result = new Callable<String>(){
//
//			@Override
//			public String call() throws Exception {
//				logger.info("副线程开始");
//				Thread.sleep(1000);
//				logger.info("副线程返回");
//				return "success";
//			}
//
//		};
//
//		logger.info("主线程返回");
//
//		return result;
//	}

//	使用 DeferredResult 异步处理
	@RequestMapping("/order")
	public 	DeferredResult<String> order() throws Exception {

		logger.info("主线程开始");

		String orderNumber = RandomStringUtils.randomNumeric(8);
		mockQueue.setPlaceOrder(orderNumber);    //  订单号放到消息队列

		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber,result);

		logger.info("主线程返回");

		return result;
	}



}
