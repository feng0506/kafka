package com.kafka2.kafka2.sendPLCMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class SendPlcInfoTest {
    private static final String topic = "real_data";

    private  String input ;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 生产者
     */
    @Scheduled(fixedRate=1000)
    public void sendToKafka(){
        input = testInput();
        this.kafkaTemplate.send(topic,input);
    }

    /**
     * 模拟传入
     */
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String val ;

    private String itemId ;

    private String deviceId;

    private String date;

    private String testInput;

  //  private String itemIdList[] = {"51","54","58","59","60","61","62","63","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","134","135","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","165","169"};

   private String itemIdList[] = {"100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","165","169"};


    private String deviceIdList[] = {"1484949506","1484949508"};
    public String testInput(){

        val = (int)(2*Math.random()) + "";

        int itemIdIndex = (int)(itemIdList.length * Math.random());
        itemId = itemIdList[itemIdIndex];

        int deviceIdIndex = (int)(deviceIdList.length * Math.random());
        deviceId = deviceIdList[deviceIdIndex];

        switch (itemId){
            case "169":
                val = (float)( 0.5 * Math.random() + 1.5) + "";
                break;
            case "165":
                val = (float)(10 * Math.random() + 90) + "";
                break;
        }

        date = df.format(new Date());

        testInput = "[{\"val\":\""+val+"\",\"itemId\":\""+itemId+"\",\"dataTime\":\""+date+"\",\"deviceId\":\""+deviceId+"\"}]";


        return testInput;
    }

}
