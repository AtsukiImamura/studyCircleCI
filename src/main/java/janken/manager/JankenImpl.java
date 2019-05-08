package janken.manager;

import janken.constants.JankenHand;
import janken.exceptions.HandInputOutOfRangeException;

public class JankenImpl implements Janken{

    /**
     * コンピュータとじゃんけんをする
     * @param hand ユーザーの手。{@code janken.constants.JankenHand}クラスの定数で指定
     * @return じゃんけんの結果。 {@code janken.constants.JankenJudgement} クラスの定数で返す
     * @throws janken.exceptions.HandInputOutOfRangeException 入力した手が定義されていない場合
     */
    @Override
    public int janken(int hand) throws HandInputOutOfRangeException{
        if(hand != JankenHand.PAPER && hand != JankenHand.SCISSOR && hand != JankenHand.ROCK)
            throw new HandInputOutOfRangeException("The hand is not correct. This method only accept a constant value of JankenHand class.  hand = "+hand);
        
        int myHand = this.getRandomHand();
        return this.judge(hand, myHand);
    }

    /**
     * じゃんけんの手をランダムに出す。
     * @return じゃんけんの手。{@code janken.constants.JankenHand}クラスの定数
     */
    private int getRandomHand() throws RuntimeException{
        int rand = (int)(Math.random()*3);

        switch(rand){
            case JankenHand.PAPER:
                return JankenHand.PAPER;
            case JankenHand.SCISSOR:
                return JankenHand.SCISSOR;
            case JankenHand.ROCK:
                return JankenHand.ROCK;
            default:
            return JankenHand.ROCK;
        }
    }

    /**
     * 勝ち負けを判断する
     * @param enemyHand コンピュータにとっての相手（ユーザー）の手。{@code janken.constants.JankenHand}クラスの定数で指定
     * @param myHand 自身の手。{@code janken.constants.JankenHand}クラスの定数で指定
     * @return じゃんけんの結果。 {@code janken.constants.JankenJudgement} クラスの定数で返す
     */
    private int judge(int enemyHand, int myHand) throws RuntimeException{
        return (3 + (enemyHand - myHand)) % 3;
    }

}