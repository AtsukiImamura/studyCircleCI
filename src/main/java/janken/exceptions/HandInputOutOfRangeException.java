package janken.exceptions;

/**
 * ユーザー入力の手が定義されていない場合に発行する例外
 */
public class HandInputOutOfRangeException extends Exception{

    public HandInputOutOfRangeException(String msg){
        super(msg);
    }

    public HandInputOutOfRangeException(){
        super("Your hand is out of range.");
    }
}