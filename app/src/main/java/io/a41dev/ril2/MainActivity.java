package io.a41dev.ril2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import io.a41dev.ril2.telephony.cat.AppInterface;
import io.a41dev.ril2.telephony.cat.CatCmdMessage;
import io.a41dev.ril2.telephony.cat.CommandDetails;
import io.a41dev.ril2.telephony.cat.DisplayTextParams;
import io.a41dev.ril2.telephony.cat.TextMessage;


public class MainActivity extends Activity {

    CatCmdMessage catCmdMessage;
   CommandDetails commandDetails;
    DisplayTextParams commandParams;
    TextMessage textMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commandDetails = new CommandDetails();

        commandDetails.typeOfCommand = AppInterface.CommandType.SEND_USSD.value();

        textMessage = new TextMessage();
        textMessage.text = "*130*2%23";

        commandParams = new DisplayTextParams(commandDetails,textMessage);


        catCmdMessage = new CatCmdMessage(commandParams);

/*
        catCmdMessage.mCmdDet = commandDetails;
        catCmdMessage.*/

        Intent intent = new Intent(AppInterface.CAT_CMD_ACTION);
        intent.putExtra("STK CMD", catCmdMessage);
        intent.putExtra("SLOT_ID", 0);
        //CatLog.d(this, "Sending CmdMsg: " + cmdMsg+ " on slotid:" + mSlotId);
        sendBroadcast(intent);
        sendBroadcast(intent/*,"android.permission.RECEIVE_STK_COMMANDS"*/);
    }
}
