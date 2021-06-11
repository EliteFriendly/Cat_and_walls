package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public static int[][] pole = new int[9][9];
    public static int x2 = 4, y2 = 4, hode = 0;

    /*public void out() {
        String str = "";
        TextView all = findViewById(R.id.all);
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                str += pole[j][i] + "     ";
            }
            str += "\n";
        }
        all.setText(str);
    }*/

    public boolean pl1_hode(int n) {
        TextView help = findViewById(R.id.help);

        if (n == 1 && (pole[x2][y2 - 1]) == 0) {//вверх
            pole[x2][y2] = 0;
            y2 = y2 - 1;
            pole[x2][y2] = 2;
            return true;
        }

        if (n == 2 && (pole[x2 + 1][y2]) == 0) {//вправо
            pole[x2][y2] = 0;
            x2 = x2 + 1;
            pole[x2][y2] = 2;
            return true;
        }

        if (n == 3 && (pole[x2][y2 + 1]) == 0) {//вниз
            pole[x2][y2] = 0;
            y2 = y2 + 1;
            pole[x2][y2] = 2;
            return true;
        }

        if (n == 4 && (pole[x2 - 1][y2]) == 0) {//влево
            pole[x2][y2] = 0;
            x2 = x2 - 1;
            pole[x2][y2] = 2;
            return true;
        } else {
            help.setText("Стенка\nВыберите другое направление");
            return false;
        }


    }

    public boolean pl2_hode(int x1, int y1) {
        TextView help = findViewById(R.id.help);
        if (pole[x1][y1] == 1 || pole[x1][y1] == 2) {
            help.setText("Вы не можете сюда походить, введите координаты повторно");


            return false;
        } else {
            pole[x1][y1] = 1;
            return true;
        }

    }

    public void clean() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] != 1 && pole[j][i] != 2) {
                    pole[j][i] = 0;
                }
            }
        }
    }

    public void cikl() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] == 1) {
                    zap(j, i);
                }
            }
        }
    }

    public void zap(int x, int y) {
        int x1 = x, y1 = y;
        try {
            while (pole[x][y - 1] != 1) {
                if (pole[x][y - 1] == 2) {
                    y = y - 1;
                }
                y = y - 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x][y + 1] != 1) {
                if (pole[x][y + 1] == 2) {
                    y = y + 1;
                }
                y = y + 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }


            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x - 1][y] != 1) {
                if (pole[x - 1][y] == 2) {
                    x = x - 1;
                }
                x = x - 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x + 1][y] != 1) {
                if (pole[x + 1][y] == 2) {
                    x = x + 1;
                }
                x = x + 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }

    }

    public void proverka(int x, int y) {
        Button button = findViewById(R.id.but);
        int x1 = x, y1 = y;
        TextView help = findViewById(R.id.help);
        boolean t = true;
        try {
            while (pole[x][y - 1] != 1) {
                y = y - 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x][y + 1] != 1) {
                y = y + 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x - 1][y] != 1) {
                x = x - 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x + 1][y] != 1) {
                x = x + 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }


        if (t == true) {
            end_game(2);
        }
    }

    public void find12() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] == 12) {
                    rec(j, i);


                }
            }
        }
    }

    public void rec(int x, int y) {
        if (pole[x + 1][y] != 12 && pole[x + 1][y] != 1 && pole[x + 1][y] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x][y + 1] != 12 && pole[x][y + 1] != 1 && pole[x][y + 1] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x - 1][y] != 12 && pole[x - 1][y] != 1 && pole[x - 1][y] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x][y - 1] != 12 && pole[x][y - 1] != 1 && pole[x][y - 1] != 2) {
            pole[x][y] = 0;
        }


        if (pole[x][y - 1] == 12 && pole[x][y] == 0) {
            rec(x, y - 1);
        }
        if (pole[x][y + 1] == 12 && pole[x][y] == 0) {
            rec(x, y + 1);
        }
        if (pole[x + 1][y] == 12 && pole[x][y] == 0) {
            rec(x + 1, y);
        }
        if (pole[x - 1][y] == 12 && pole[x][y] == 0) {
            rec(x - 1, y);
        }


    }

    public void over() {
        int[] views = new int[]{R.id.c0_0, R.id.c0_1, R.id.c0_2, R.id.c0_3, R.id.c0_4, R.id.c0_5, R.id.c0_6, R.id.c0_7, R.id.c0_8,
                R.id.c1_0, R.id.c1_1, R.id.c1_2, R.id.c1_3, R.id.c1_4, R.id.c1_5, R.id.c1_6, R.id.c1_7, R.id.c1_8,
                R.id.c2_0, R.id.c2_1, R.id.c2_2, R.id.c2_3, R.id.c2_4, R.id.c2_5, R.id.c2_6, R.id.c2_7, R.id.c2_8,
                R.id.c2_10, R.id.c2_11, R.id.c2_12, R.id.c2_13, R.id.c2_14, R.id.c2_15, R.id.c2_16, R.id.c2_17, R.id.c2_18,
                R.id.c2_19, R.id.c2_20, R.id.c2_21, R.id.c2_22, R.id.c2_23, R.id.c2_24, R.id.c2_25, R.id.c2_26, R.id.c2_27,
                R.id.c2_28, R.id.c2_29, R.id.c2_30, R.id.c2_31, R.id.c2_32, R.id.c2_33, R.id.c2_34, R.id.c2_35, R.id.c2_36,
                R.id.c2_37, R.id.c2_38, R.id.c2_39, R.id.c2_40, R.id.c2_41, R.id.c2_42, R.id.c2_43, R.id.c2_44, R.id.c2_45,
                R.id.c2_46, R.id.c2_47, R.id.c2_48, R.id.c2_49, R.id.c2_50, R.id.c2_51, R.id.c2_52, R.id.c2_53, R.id.c2_54,
                R.id.c2_55, R.id.c2_56, R.id.c2_57, R.id.c2_58, R.id.c2_59, R.id.c2_60, R.id.c2_61, R.id.c2_62, R.id.c2_63};
        View up = findViewById(R.id.UP);
        View right = findViewById(R.id.RIGHT);
        View down = findViewById(R.id.DOWN);
        View left = findViewById(R.id.LEFT);
        Button but = findViewById(R.id.but);
        TextView xv = findViewById(R.id.xv);
        TextView yv = findViewById(R.id.yv);
        EditText x = findViewById(R.id.x);
        EditText y = findViewById(R.id.y);
        TextView help = findViewById(R.id.help);
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                pole[j][i] = 0;
            }
        }
        for (int i=0;i<81;i++){
            View view=findViewById(views[i]);
            view.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        right.setVisibility(right.VISIBLE);
        down.setVisibility(down.VISIBLE);
        left.setVisibility(left.VISIBLE);
        up.setVisibility(up.VISIBLE);
        help.setText("Ход кота\nВыберите напраление");
        x2 = 4;
        y2 = 4;
        hode = 0;
        colour(x2+1,y2+1,1);
        pole[x2][y2] = 2;
    }

    public void end_game(int w) {
        View up = findViewById(R.id.UP);
        View right = findViewById(R.id.RIGHT);
        View down = findViewById(R.id.DOWN);
        View left = findViewById(R.id.LEFT);

        Button but = findViewById(R.id.but);
        TextView xv = findViewById(R.id.xv);
        TextView yv = findViewById(R.id.yv);
        EditText x = findViewById(R.id.x);
        EditText y = findViewById(R.id.y);
        TextView help = findViewById(R.id.help);

        right.setVisibility(right.GONE);
        down.setVisibility(down.GONE);
        left.setVisibility(left.GONE);
        up.setVisibility(up.GONE);
        if (w == 2) {
            help.setText("Кот в клетке");
        }
        if (w == 1) {
            help.setText("Кот сбежал");
        }


        but.setVisibility(but.VISIBLE);
        but.setText("Заново?");
        hode = 1;
        xv.setVisibility(xv.GONE);
        yv.setVisibility(yv.GONE);
        x.setVisibility(x.GONE);
        y.setVisibility(y.GONE);
    }

    public void pl1_visibility() {
        View up = findViewById(R.id.UP);
        View right = findViewById(R.id.RIGHT);
        View down = findViewById(R.id.DOWN);
        View left = findViewById(R.id.LEFT);

        Button but = findViewById(R.id.but);
        TextView xv = findViewById(R.id.xv);
        TextView yv = findViewById(R.id.yv);
        EditText x = findViewById(R.id.x);
        EditText y = findViewById(R.id.y);
        TextView help = findViewById(R.id.help);

        right.setVisibility(right.GONE);
        down.setVisibility(down.GONE);
        left.setVisibility(left.GONE);
        up.setVisibility(up.GONE);

        help.setText("Ход стенки\nВыберите точку");

        but.setVisibility(but.VISIBLE);
        xv.setVisibility(xv.VISIBLE);
        yv.setVisibility(yv.VISIBLE);
        x.setVisibility(x.VISIBLE);
        y.setVisibility(y.VISIBLE);
    }

    public void pl2_visibility() {
        View up = findViewById(R.id.UP);
        View right = findViewById(R.id.RIGHT);
        View down = findViewById(R.id.DOWN);
        View left = findViewById(R.id.LEFT);

        Button but = findViewById(R.id.but);
        TextView xv = findViewById(R.id.xv);
        TextView yv = findViewById(R.id.yv);
        EditText x = findViewById(R.id.x);
        EditText y = findViewById(R.id.y);
        TextView help = findViewById(R.id.help);

        right.setVisibility(right.VISIBLE);
        down.setVisibility(down.VISIBLE);
        left.setVisibility(left.VISIBLE);
        up.setVisibility(up.VISIBLE);

        help.setText("Ход кота\nВыберите направление");

        but.setVisibility(but.GONE);
        xv.setVisibility(xv.GONE);
        yv.setVisibility(yv.GONE);
        x.setVisibility(x.GONE);
        y.setVisibility(y.GONE);
    }

    public void colour(int x, int y, int type) {
        int[] views = new int[]{R.id.c0_0, R.id.c0_1, R.id.c0_2, R.id.c0_3, R.id.c0_4, R.id.c0_5, R.id.c0_6, R.id.c0_7, R.id.c0_8,
                R.id.c1_0, R.id.c1_1, R.id.c1_2, R.id.c1_3, R.id.c1_4, R.id.c1_5, R.id.c1_6, R.id.c1_7, R.id.c1_8,
                R.id.c2_0, R.id.c2_1, R.id.c2_2, R.id.c2_3, R.id.c2_4, R.id.c2_5, R.id.c2_6, R.id.c2_7, R.id.c2_8,
                R.id.c2_10, R.id.c2_11, R.id.c2_12, R.id.c2_13, R.id.c2_14, R.id.c2_15, R.id.c2_16, R.id.c2_17, R.id.c2_18,
                R.id.c2_19, R.id.c2_20, R.id.c2_21, R.id.c2_22, R.id.c2_23, R.id.c2_24, R.id.c2_25, R.id.c2_26, R.id.c2_27,
                R.id.c2_28, R.id.c2_29, R.id.c2_30, R.id.c2_31, R.id.c2_32, R.id.c2_33, R.id.c2_34, R.id.c2_35, R.id.c2_36,
                R.id.c2_37, R.id.c2_38, R.id.c2_39, R.id.c2_40, R.id.c2_41, R.id.c2_42, R.id.c2_43, R.id.c2_44, R.id.c2_45,
                R.id.c2_46, R.id.c2_47, R.id.c2_48, R.id.c2_49, R.id.c2_50, R.id.c2_51, R.id.c2_52, R.id.c2_53, R.id.c2_54,
                R.id.c2_55, R.id.c2_56, R.id.c2_57, R.id.c2_58, R.id.c2_59, R.id.c2_60, R.id.c2_61, R.id.c2_62, R.id.c2_63};
        View view = findViewById(views[9 * (y - 1) + x - 1]);
        if (type == 2) {
            view.setBackgroundColor(Color.parseColor("#373737"));
        }
        if (type == 0) {
            view.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        if (type == 1) {
            view.setBackgroundColor(Color.parseColor("#FB0202"));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView help = findViewById(R.id.help);
        help.setText("Ход кота\nВыберите направление");
        View c2_23 = findViewById(R.id.c2_23);
        c2_23.setBackgroundColor(Color.parseColor("#FB0202"));

    }

    public void push(View view) {
        boolean t;
        Button but = findViewById(R.id.but);
        TextView xv = findViewById(R.id.xv);
        TextView yv = findViewById(R.id.yv);
        EditText x = findViewById(R.id.x);
        EditText y = findViewById(R.id.y);
        int x1, y1;
        if (hode == 1) {
            over();
            but.setText("Ввести");
        }
        try {
            x1 = Integer.parseInt(String.valueOf((x.getText().toString()).charAt(0)));
            y1 = Integer.parseInt(String.valueOf((y.getText().toString()).charAt(0)));
            t=pl2_hode(x1-1,y1-1);
            if (t==true){
                colour(x1, y1, 2);
                cikl();
                find12();
                proverka(x2, y2);
                clean();
                pl2_visibility();
            }
            //out();
        } catch (Exception e) {
        }


    }


    public void up(View view) {
        boolean t;
        int x = x2 + 1, y = y2 + 1;
        try {
            t = pl1_hode(1);
            if (t == true) {
                pl1_visibility();
                colour(x, y, 0);
                colour(x2 + 1, y2 + 1, 1);
                //out();
            }
        } catch (Exception e) {
            end_game(1);
        }


    }

    public void right(View view1) {
        boolean t;
        int x = x2 + 1, y = y2 + 1;
        try {
            t = pl1_hode(2);
            if (t == true) {
                pl1_visibility();
                colour(x, y, 0);
                colour(x2 + 1, y2 + 1, 1);
                //out();
            }
        } catch (Exception e) {
            end_game(1);
        }


    }

    public void down(View view2) {
        boolean t;
        int x = x2 + 1, y = y2 + 1;
        try {
            t = pl1_hode(3);
            if (t == true) {
                pl1_visibility();
                colour(x, y, 0);
                colour(x2 + 1, y2 + 1, 1);
                //out();
            }
        } catch (Exception e) {
            end_game(1);
        }


    }

    public void left(View view3) {
        boolean t;
        int x = x2 + 1, y = y2 + 1;
        try {
            t = pl1_hode(4);
            if (t == true) {
                pl1_visibility();
                colour(x, y, 0);
                colour(x2 + 1, y2 + 1, 1);
                //out();
            }
        } catch (Exception e) {
            end_game(1);
        }

    }

}