package io.a41dev.ril2.telephony.cat;

import android.graphics.Bitmap;

public class DisplayTextParams extends CommandParams {
    TextMessage mTextMsg;

    public DisplayTextParams(CommandDetails cmdDet, TextMessage textMsg) {
        super(cmdDet);
        mTextMsg = textMsg;
    }

    @Override
    boolean setIcon(Bitmap icon) {
        if (icon != null && mTextMsg != null) {
            mTextMsg.icon = icon;
            return true;
        }
        return false;
    }
}