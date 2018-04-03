package jonghoon.pc_remote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ip;
    TextView port;
    Button go;

    String s;

    private int port_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        port_num = (int)((Math.random()*9999)+2000);

        while (port_num == 3306 || port_num == 1521 || port_num == 8080 || port_num == 1433 || port_num > 9999 || port_num < 1500) {
            port_num = (int)((Math.random()*9999)+2000);
        }

        ip = (EditText)findViewById(R.id.ip);
        port = (TextView)findViewById(R.id.port);
        go = (Button)findViewById(R.id.go);

        port.setText(String.valueOf(port_num));

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("port_num", port_num);
                i.putExtra("ip_num", ip.getText().toString());
                startActivity(i);
            }
        });
    }
}
