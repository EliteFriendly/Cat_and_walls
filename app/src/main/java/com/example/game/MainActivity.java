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
    public static int x2 = 4, y2 = 4, hode = 1,plhode=1;

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
        if (pole[x1-1][y1-1] == 1 || pole[x1-1][y1-1] == 2) {
            help.setText("Вы не можете сюда походить, введите координаты повторно");


            return false;
        } else {
            pole[x1-1][y1-1] = 1;
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
        View up = findViewById(R.id.UP);
        View right = findViewById(R.id.RIGHT);
        View down = findViewById(R.id.DOWN);
        View left = findViewById(R.id.LEFT);
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
            hode=3;
            right.setVisibility(right.GONE);
            down.setVisibility(down.GONE);
            left.setVisibility(left.GONE);
            up.setVisibility(up.GONE);
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
        but.setVisibility(but.GONE);
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


        if (w == 2) {
            help.setText("Кот в клетке");
            hode=3;
        }
        if (w == 1) {
            help.setText("Кот сбежал");
        }
        right.setVisibility(right.GONE);
        down.setVisibility(down.GONE);
        left.setVisibility(left.GONE);
        up.setVisibility(up.GONE);

        but.setVisibility(but.VISIBLE);
        but.setText("Заново?");
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
        if (hode!=3){
            right.setVisibility(right.VISIBLE);
            down.setVisibility(down.VISIBLE);
            left.setVisibility(left.VISIBLE);
            up.setVisibility(up.VISIBLE);
            help.setText("Ход кота\nВыберите направление");
        }



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
        over();

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
                plhode=2;
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
                plhode=2;
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
                plhode=2;
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
                plhode=2;
                //out();
            }
        } catch (Exception e) {
            end_game(1);
        }

    }

    public void c1(View view){ if(plhode==2){   if(pl2_hode(1, 1)==true){   colour(1, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; end_game(2); }  } }
    public void c2(View view){ if(plhode==2){   if(pl2_hode(2, 1)==true){   colour(2, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c3(View view){ if(plhode==2){   if(pl2_hode(3, 1)==true){   colour(3, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c4(View view){ if(plhode==2){   if(pl2_hode(4, 1)==true){   colour(4, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c5(View view){ if(plhode==2){   if(pl2_hode(5, 1)==true){   colour(5, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c6(View view){ if(plhode==2){   if(pl2_hode(6, 1)==true){   colour(6, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c7(View view){ if(plhode==2){   if(pl2_hode(7, 1)==true){   colour(7, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c8(View view){ if(plhode==2){   if(pl2_hode(8, 1)==true){   colour(8, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c9(View view){ if(plhode==2){   if(pl2_hode(9, 1)==true){   colour(9, 1, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c10(View view){ if(plhode==2){   if(pl2_hode(1, 2)==true){   colour(1, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c11(View view){ if(plhode==2){   if(pl2_hode(2, 2)==true){   colour(2, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c12(View view){ if(plhode==2){   if(pl2_hode(3, 2)==true){   colour(3, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c13(View view){ if(plhode==2){   if(pl2_hode(4, 2)==true){   colour(4, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c14(View view){ if(plhode==2){   if(pl2_hode(5, 2)==true){   colour(5, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c15(View view){ if(plhode==2){   if(pl2_hode(6, 2)==true){   colour(6, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c16(View view){ if(plhode==2){   if(pl2_hode(7, 2)==true){   colour(7, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c17(View view){ if(plhode==2){   if(pl2_hode(8, 2)==true){   colour(8, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c18(View view){ if(plhode==2){   if(pl2_hode(9, 2)==true){   colour(9, 2, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c19(View view){ if(plhode==2){   if(pl2_hode(1, 3)==true){   colour(1, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c20(View view){ if(plhode==2){   if(pl2_hode(2, 3)==true){   colour(2, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c21(View view){ if(plhode==2){   if(pl2_hode(3, 3)==true){   colour(3, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c22(View view){ if(plhode==2){   if(pl2_hode(4, 3)==true){   colour(4, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c23(View view){ if(plhode==2){   if(pl2_hode(5, 3)==true){   colour(5, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c24(View view){ if(plhode==2){   if(pl2_hode(6, 3)==true){   colour(6, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c25(View view){ if(plhode==2){   if(pl2_hode(7, 3)==true){   colour(7, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c26(View view){ if(plhode==2){   if(pl2_hode(8, 3)==true){   colour(8, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c27(View view){ if(plhode==2){   if(pl2_hode(9, 3)==true){   colour(9, 3, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c28(View view){ if(plhode==2){   if(pl2_hode(1, 4)==true){   colour(1, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c29(View view){ if(plhode==2){   if(pl2_hode(2, 4)==true){   colour(2, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c30(View view){ if(plhode==2){   if(pl2_hode(3, 4)==true){   colour(3, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c31(View view){ if(plhode==2){   if(pl2_hode(4, 4)==true){   colour(4, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c32(View view){ if(plhode==2){   if(pl2_hode(5, 4)==true){   colour(5, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c33(View view){ if(plhode==2){   if(pl2_hode(6, 4)==true){   colour(6, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c34(View view){ if(plhode==2){   if(pl2_hode(7, 4)==true){   colour(7, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c35(View view){ if(plhode==2){   if(pl2_hode(8, 4)==true){   colour(8, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c36(View view){ if(plhode==2){   if(pl2_hode(9, 4)==true){   colour(9, 4, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c37(View view){ if(plhode==2){   if(pl2_hode(1, 5)==true){   colour(1, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c38(View view){ if(plhode==2){   if(pl2_hode(2, 5)==true){   colour(2, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c39(View view){ if(plhode==2){   if(pl2_hode(3, 5)==true){   colour(3, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c40(View view){ if(plhode==2){   if(pl2_hode(4, 5)==true){   colour(4, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c41(View view){ if(plhode==2){   if(pl2_hode(5, 5)==true){   colour(5, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c42(View view){ if(plhode==2){   if(pl2_hode(6, 5)==true){   colour(6, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c43(View view){ if(plhode==2){   if(pl2_hode(7, 5)==true){   colour(7, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c44(View view){ if(plhode==2){   if(pl2_hode(8, 5)==true){   colour(8, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c45(View view){ if(plhode==2){   if(pl2_hode(9, 5)==true){   colour(9, 5, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c46(View view){ if(plhode==2){   if(pl2_hode(1, 6)==true){   colour(1, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c47(View view){ if(plhode==2){   if(pl2_hode(2, 6)==true){   colour(2, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c48(View view){ if(plhode==2){   if(pl2_hode(3, 6)==true){   colour(3, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c49(View view){ if(plhode==2){   if(pl2_hode(4, 6)==true){   colour(4, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c50(View view){ if(plhode==2){   if(pl2_hode(5, 6)==true){   colour(5, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c51(View view){ if(plhode==2){   if(pl2_hode(6, 6)==true){   colour(6, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c52(View view){ if(plhode==2){   if(pl2_hode(7, 6)==true){   colour(7, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c53(View view){ if(plhode==2){   if(pl2_hode(8, 6)==true){   colour(8, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c54(View view){ if(plhode==2){   if(pl2_hode(9, 6)==true){   colour(9, 6, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c55(View view){ if(plhode==2){   if(pl2_hode(1, 7)==true){   colour(1, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c56(View view){ if(plhode==2){   if(pl2_hode(2, 7)==true){   colour(2, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c57(View view){ if(plhode==2){   if(pl2_hode(3, 7)==true){   colour(3, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c58(View view){ if(plhode==2){   if(pl2_hode(4, 7)==true){   colour(4, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c59(View view){ if(plhode==2){   if(pl2_hode(5, 7)==true){   colour(5, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c60(View view){ if(plhode==2){   if(pl2_hode(6, 7)==true){   colour(6, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c61(View view){ if(plhode==2){   if(pl2_hode(7, 7)==true){   colour(7, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c62(View view){ if(plhode==2){   if(pl2_hode(8, 7)==true){   colour(8, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c63(View view){ if(plhode==2){   if(pl2_hode(9, 7)==true){   colour(9, 7, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c64(View view){ if(plhode==2){   if(pl2_hode(1, 8)==true){   colour(1, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c65(View view){ if(plhode==2){   if(pl2_hode(2, 8)==true){   colour(2, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c66(View view){ if(plhode==2){   if(pl2_hode(3, 8)==true){   colour(3, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c67(View view){ if(plhode==2){   if(pl2_hode(4, 8)==true){   colour(4, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c68(View view){ if(plhode==2){   if(pl2_hode(5, 8)==true){   colour(5, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c69(View view){ if(plhode==2){   if(pl2_hode(6, 8)==true){   colour(6, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c70(View view){ if(plhode==2){   if(pl2_hode(7, 8)==true){   colour(7, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c71(View view){ if(plhode==2){   if(pl2_hode(8, 8)==true){   colour(8, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c72(View view){ if(plhode==2){   if(pl2_hode(9, 8)==true){   colour(9, 8, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c73(View view){ if(plhode==2){   if(pl2_hode(1, 9)==true){   colour(1, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c74(View view){ if(plhode==2){   if(pl2_hode(2, 9)==true){   colour(2, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c75(View view){ if(plhode==2){   if(pl2_hode(3, 9)==true){   colour(3, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c76(View view){ if(plhode==2){   if(pl2_hode(4, 9)==true){   colour(4, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c77(View view){ if(plhode==2){   if(pl2_hode(5, 9)==true){   colour(5, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c78(View view){ if(plhode==2){   if(pl2_hode(6, 9)==true){   colour(6, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c79(View view){ if(plhode==2){   if(pl2_hode(7, 9)==true){   colour(7, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c80(View view){ if(plhode==2){   if(pl2_hode(8, 9)==true){   colour(8, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
    public void c81(View view){ if(plhode==2){   if(pl2_hode(9, 9)==true){   colour(9, 9, 2);  cikl(); find12();proverka(x2, y2); clean();  pl2_visibility();  plhode=1; }  } }
}