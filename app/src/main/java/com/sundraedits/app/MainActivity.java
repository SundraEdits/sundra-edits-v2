package com.sundraedits.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    int bg = Color.rgb(18, 19, 22);
    int card = Color.rgb(31, 32, 36);
    int gold = Color.rgb(211, 174, 111);
    int white = Color.WHITE;
    int muted = Color.rgb(165, 165, 165);

    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(bg);
        getWindow().setNavigationBarColor(bg);

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(bg);

        main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(dp(20), dp(25), dp(20), dp(30));

        scroll.addView(main);
        setContentView(scroll);

        addHeader();
        addWelcome();
        addSectionTitle("BUSINESS OVERVIEW");
        addStats();
        addSectionTitle("MANAGE YOUR BUSINESS");
        addMenu("Clients", "Manage your customers", "01");
        addMenu("Projects", "Track editing projects", "02");
        addMenu("Payments", "Track received payments", "03");
        addMenu("Invoices", "Create professional invoices", "04");
        addMenu("Deliveries", "Manage final video delivery", "05");
        addMenu("Reports", "View business performance", "06");
        addMenu("Settings", "App and backup settings", "07");

        addFooter();
    }

    void addHeader() {
        TextView brand = text("SUNDRA EDITS", 23, gold, true);
        main.addView(brand);

        TextView version = text("BUSINESS MANAGER  •  VERSION 2.0", 10, muted, true);
        version.setPadding(0, dp(5), 0, dp(20));
        main.addView(version);
    }

    void addWelcome() {
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setPadding(dp(18), dp(20), dp(18), dp(20));
        box.setBackground(round(card, 16));

        TextView hello = text("Welcome Back!", 22, white, true);
        box.addView(hello);

        TextView subtitle = text(
            "Manage your creative business in one place.",
            13, muted, false
        );
        subtitle.setPadding(0, dp(8), 0, 0);
        box.addView(subtitle);

        main.addView(box, matchWrap());
    }

    void addSectionTitle(String title) {
        TextView t = text(title, 12, gold, true);
        t.setPadding(0, dp(25), 0, dp(12));
        main.addView(t);
    }

    void addStats() {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);

        row.addView(statCard("0", "TOTAL CLIENTS"),
                new LinearLayout.LayoutParams(0, dp(95), 1));

        View space = new View(this);
        row.addView(space, new LinearLayout.LayoutParams(dp(10), 1));

        row.addView(statCard("0", "ACTIVE PROJECTS"),
                new LinearLayout.LayoutParams(0, dp(95), 1));

        main.addView(row);
    }

    View statCard(String number, String label) {
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setGravity(Gravity.CENTER_VERTICAL);
        box.setPadding(dp(14), dp(10), dp(10), dp(10));
        box.setBackground(round(card, 14));

        box.addView(text(number, 25, gold, true));

        TextView small = text(label, 9, muted, true);
        small.setPadding(0, dp(5), 0, 0);
        box.addView(small);

        return box;
    }

    void addMenu(String name, String description, String number) {
        LinearLayout item = new LinearLayout(this);
        item.setOrientation(LinearLayout.HORIZONTAL);
        item.setGravity(Gravity.CENTER_VERTICAL);
        item.setPadding(dp(15), dp(15), dp(15), dp(15));
        item.setBackground(round(card, 13));

        LinearLayout.LayoutParams params = matchWrap();
        params.bottomMargin = dp(10);
        main.addView(item, params);

        TextView num = text(number, 12, gold, true);
        item.addView(num);

        LinearLayout details = new LinearLayout(this);
        details.setOrientation(LinearLayout.VERTICAL);
        details.setPadding(dp(15), 0, 0, 0);

        details.addView(text(name, 16, white, true));

        TextView sub = text(description, 11, muted, false);
        sub.setPadding(0, dp(4), 0, 0);
        details.addView(sub);

        item.addView(details, new LinearLayout.LayoutParams(
                0, -2, 1
        ));

        item.addView(text("›", 25, gold, true));
    }

    void addFooter() {
        TextView footer = text(
            "SUNDRA EDITS  •  YOUR BUSINESS, ORGANIZED.",
            9, muted, true
        );
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, dp(25), 0, dp(10));
        main.addView(footer);
    }

    TextView text(String value, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        if (bold) {
            t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        }
        return t;
    }

    GradientDrawable round(int color, int radius) {
        GradientDrawable shape = new GradientDrawable();
        shape.setColor(color);
        shape.setCornerRadius(dp(radius));
        return shape;
    }

    LinearLayout.LayoutParams matchWrap() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }
}
