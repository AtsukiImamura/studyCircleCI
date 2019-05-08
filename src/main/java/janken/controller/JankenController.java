package janken.controller;

import java.util.Scanner;
import janken.constants.JankenHand;
import janken.constants.JankenJudgement;
import janken.exceptions.HandInputOutOfRangeException;
import janken.manager.JankenImpl;

public class JankenController{


    public JankenController(){
    }

    /**
     * ユーザーと一度じゃんけんの勝負をして結果を通知する
     */
    public void janken(){
        this.printlnMsg("SELECT YOUR HAND:");
        this.printlnMsg(String.format("[%d] ROCK   [%d] SCISSOR   [%d] PAPER", JankenHand.ROCK, JankenHand.SCISSOR, JankenHand.PAPER));

        String stringHand = null;
        while(stringHand == null || stringHand.equals("")){
            this.printMsg("");
            stringHand = this.scanUserInput();
        }

        this.doJanken(stringHand);
    }

    /**
     * ユーザーとじゃんけんを対戦する。１勝負するごとに終了するか尋ね、ユーザーが終了するまで勝負を続ける
     */
    public void jankenInfinite(){
        sayHello();
        boolean next = true;
        while(next){

            janken();
            this.printlnMsg("[0] once more  [1] quit");
            this.printMsg("");

            String strSelection = this.scanUserInput();
            if(strSelection == null || !strSelection.equals("0")){
                next = false;
            }
        }
        sayBye();
    }

    /**
     * じゃんけんを実行して結果を表示する
     * @param stringHand ユーザーの手（入力されたものがそのまま入ることを想定）
     */
    public void doJanken(String stringHand){
        try{
            int hand = Integer.parseInt(stringHand);
            JankenImpl janken = new JankenImpl();
            int result = janken.janken(hand);

            String strRes = "";
            switch(result){
                case JankenJudgement.WIN:
                    strRes = "congratulation! You Won!";
                    break;
                case JankenJudgement.DRAW:
                    strRes = "Draw";
                    break;
                case JankenJudgement.ROSE:
                    strRes = "You rose...";
                    break;
            }
            
            this.printlnMsg("******* " + strRes + " *******");
            this.printlnMsg("");

        }catch(HandInputOutOfRangeException ie){
            this.printErrorMsg("=== "+ie.getMessage()+" ===");
        }catch(java.lang.NumberFormatException nx){
            this.printErrorMsg("=== Error on parsing string hand. stringHand: "+stringHand+" ===");
        }catch(RuntimeException rx){
            this.printErrorMsg("=== Error with input value. ===");
            rx.printStackTrace();
        }catch(Exception e){
            this.printErrorMsg("=== Error ===");
            e.printStackTrace();
        }
    }

    /**
     * ユーザー入力を読み取る。エラーが起きた場合は {@code null} を返す
     */
    private String scanUserInput(){
        String str = null;
        try {
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
        } catch (Exception e) {
            
        }
        return str;
    }

    /**
     * インタラクティブCUI風のメッセージを表示する。文末を改行する。
     * @param msg 表示内容
     */
    private void printlnMsg(String msg){
        System.out.println(this.getMsgPrefix() + msg);
    }

    /**
     * インタラクティブCUI風のメッセージを表示する。文末は改行しない
     * @param msg 表示内容
     */
    private void printMsg(String msg){
        System.out.print(this.getMsgPrefix() + msg);
    }

    /**
     * エラーメッセージを表示。コンソールが対応している場合は赤色の文字で表示される
     * @param msg
     */
    private void printErrorMsg(String msg){
        System.out.println("\u001b[00;31m "+msg+" \u001b[00m");
    }

    /**
     * インタラクティブCUI風のメッセージの接頭辞を作成して返す
     * @return
     */
    private String getMsgPrefix(){
        return "  janken >> ";
    }

    private void sayHello(){    
        this.printlnMsg("=========================================");
        this.printlnMsg("============ W E L C O M E ============== ");
        this.printlnMsg("=========================================");
        this.printlnMsg("");
    }

    private void sayBye(){
        this.printlnMsg("");
        this.printlnMsg("Bye");
    }
}