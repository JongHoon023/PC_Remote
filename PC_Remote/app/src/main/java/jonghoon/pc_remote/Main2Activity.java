package jonghoon.pc_remote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Main2Activity extends AppCompatActivity {

    static int port;
    static Socket so;

    static String ip, command;

    private Button esc, f5, shift_f5, up, down, left, right;
    static BufferedWriter w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        esc = (Button) findViewById(R.id.esc);
        f5 = (Button) findViewById(R.id.f5);
        shift_f5 = (Button) findViewById(R.id.shift_f5);
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);

        Intent i = getIntent();
        port = i.getExtras().getInt("port_num");
        ip = i.getExtras().getString("ip_num");


        // 연결이 되었으면 연결이 되었음을 PC 로 전송함
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    so = new Socket(ip, port); // 소켓 연결
                    w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                    w.write("OK\n"); // PC 로 명령 입력
                    w.flush(); // PC 로 명령을 전송
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            so = new Socket(ip, port); // 소켓 연결
                            w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                            w.write("ESC\n"); // PC 로 명령 입력
                            w.flush(); // PC 로 명령을 전송
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            so = new Socket(ip, port); // 소켓 연결
                            w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                            w.write("F5\n"); // PC 로 명령 입력
                            w.flush(); // PC 로 명령을 전송
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

        shift_f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            so = new Socket(ip, port); // 소켓 연결
                            w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                            w.write("Shift + F5\n"); // PC 로 명령 입력
                            w.flush(); // PC 로 명령을 전송
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            so = new Socket(ip, port); // 소켓 연결
                            w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                            w.write("Up\n"); // PC 로 명령 입력
                            w.flush(); // PC 로 명령을 전송
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            so = new Socket(ip, port); // 소켓 연결
                            w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                            w.write("Down\n"); // PC 로 명령 입력
                            w.flush(); // PC 로 명령을 전송
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            so = new Socket(ip, port); // 소켓 연결
                            w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                            w.write("Left\n"); // PC 로 명령 입력
                            w.flush(); // PC 로 명령을 전송
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            so = new Socket(ip, port); // 소켓 연결
                            w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                            w.write("Right\n"); // PC 로 명령 입력
                            w.flush(); // PC 로 명령을 전송
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });
    }

    @Override
    // 액티비티가 종료되었을 때 발생
    protected void onDestroy() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    so = new Socket(ip, port); // 소켓 연결
                    w = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
                    w.write("END\n"); // PC 로 명령 입력
                    w.flush(); // PC 로 명령을 전송

                    so.close(); // 소켓을 닫음
                    w.close(); // BufferedWriter 클래스를 닫음
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        super.onDestroy();
    }
}
