package cn.edu.gdmec.s07150708.onkeytouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        tv1=new TextView(this);
        tv1.setText("我不是layout生成的，是手工创建的");
        setContentView(tv1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

             switch (keyCode){
                 case KeyEvent.KEYCODE_HOME:
                     SetMessage("按下：HOME健");
                     break;
                 case KeyEvent.KEYCODE_MENU:
                     SetMessage("按下：菜单键");
                     return true;
                 case KeyEvent.KEYCODE_BACK:
                     SetMessage("按下：回退键");
                     break;
                 case KeyEvent.KEYCODE_VOLUME_UP:
                     SetMessage("按下：声音加大键");
                     break;
                 case KeyEvent.KEYCODE_VOLUME_DOWN:
                     SetMessage("按下：声音减小键");
                     event.startTracking();
                     return true;
                 default:
                     SetMessage("按下的键码是"+keyCode);
                     break;
             }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_HOME:
                SetMessage("放开：HOME键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("放开：菜单键");
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("放开：回退键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("放开：声音加大键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("放开：声音减小键");
                break;
            default:
                SetMessage("放开的键码是" + keyCode);
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        SetMessage("长时间按键");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        if(action == MotionEvent.ACTION_CANCEL||action == MotionEvent.ACTION_DOWN||action == MotionEvent.ACTION_MOVE){
            return false;
        }
        String x=String.valueOf(event.getX());
        String y=String.valueOf(event.getY());
        SetMessage("触发坐标：("+x+","+y+")");
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SetMessage("按下返回键了");
    }
    public void SetMessage(String str){
        String oldStr=tv1.getText().toString();
        String newStr=oldStr+"\n"+str;
        tv1.setText(newStr);

    }
}
