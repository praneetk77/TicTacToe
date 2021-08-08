package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtPlayer;

    private Button btn0 , btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    private boolean player1 = true;

    private int count = 0;

    private int[] gameState = new int[9];
    //player1 = -1 , player2 = 1 , empty = 0

    private int[][] winningPositions = {
            // rows
            {0,1,2} , {3,4,5} , {6,7,8},
            //columns
            {0,3,6} , {1,4,7} , {2,5,8},
            //diagonals
            {0,4,8} , {2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();

    }

    private void initialise() {
        txtPlayer = findViewById(R.id.txtPlayer);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){
            Toast.makeText(this, "Please select a space that hasn't been taken already.", Toast.LENGTH_SHORT).show();
            return;
        }else if(v.getId()==R.id.btn0){
            if(player1){
                btn0.setText("X");
                gameState[0] = -1;
            }else{
                btn0.setText("O");
                gameState[0] = 1;
            }
        }else if(v.getId()==R.id.btn1){
            if(player1){
                btn1.setText("X");
                gameState[1] = -1;
            }else{
                btn1.setText("O");
                gameState[1] = 1;
            }
        }else if(v.getId()==R.id.btn2){
            if(player1){
                btn2.setText("X");
                gameState[2] = -1;
            }else{
                btn2.setText("O");
                gameState[2] = 1;
            }
        }else if(v.getId()==R.id.btn3){
            if(player1){
                btn3.setText("X");
                gameState[3] = -1;
            }else{
                btn3.setText("O");
                gameState[3] = 1;
            }
        }else if(v.getId()==R.id.btn4){
            if(player1){
                btn4.setText("X");
                gameState[4] = -1;
            }else{
                btn4.setText("O");
                gameState[4] = 1;
            }
        }else if(v.getId()==R.id.btn5){
            if(player1){
                btn5.setText("X");
                gameState[5] = -1;
            }else{
                btn5.setText("O");
                gameState[5] = 1;
            }
        }else if(v.getId()==R.id.btn6){
            if(player1){
                btn6.setText("X");
                gameState[6] = -1;
            }else{
                btn6.setText("O");
                gameState[6] = 1;
            }
        }else if(v.getId()==R.id.btn7){
            if(player1){
                btn7.setText("X");
                gameState[7] = -1;
            }else{
                btn7.setText("O");
                gameState[7] = 1;
            }
        }else{
            if(player1){
                btn8.setText("X");
                gameState[8] = -1;
            }else{
                btn8.setText("O");
                gameState[8] = 1;
            }
        }
        if(checkWinner()){
            if(player1){
                display1Winner();
            }else{
                display2Winner();
            }
        }else{
            count++;
            player1 = !player1;
            if(count==9){
                displayDraw();
                resetGame();
            }
            if(player1) txtPlayer.setText("Player 1 : X");
            else txtPlayer.setText("Player 2 : O");
        }
    }

    private void displayDraw() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("The game has ended in a draw.\nDo you want to play again?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
            }
        });
        builder.create().show();
    }

    private void display2Winner() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Player 2 has won the game.\nDo you want to play again?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
            }
        });
        builder.create().show();
    }

    private void display1Winner() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Player 1 has won the game.\nDo you want to play again?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
            }
        });
        builder.create().show();
    }

    private void resetGame() {
        player1 = true;
        count = 0;
        txtPlayer.setText("Player 1 : X");
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        Arrays.fill(gameState,0);
    }

    private boolean checkWinner() {
        boolean winnerResult = false;
        for(int[] winningPosition : winningPositions){
            if(gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
            gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
            gameState[winningPosition[2]]==gameState[winningPosition[0]] &&
            gameState[winningPosition[0]]!=0) winnerResult = true;
        }
        return winnerResult;
    }
}