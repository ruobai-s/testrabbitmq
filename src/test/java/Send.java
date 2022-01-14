import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    //生产消息
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        //创建mq的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接主机
        connectionFactory.setHost("192.168.16.129");
        //设置端口号
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);
        channel.basicPublish("","hello",null,"hello rabbitmq".getBytes());
        channel.close();
        connection.close();
    }
}
