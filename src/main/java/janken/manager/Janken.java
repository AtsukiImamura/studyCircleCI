package janken.manager;

import janken.exceptions.HandInputOutOfRangeException;

interface Janken {

    /**
     * コンピュータとじゃんけんをする
     * @param hand ユーザーの手。{@code janken.constants.JankenHand}クラスの定数で指定
     * @return じゃんけんの結果。 {@code janken.constants.JankenJudgement} クラスの定数で返す
     */
    public int janken(int hand) throws HandInputOutOfRangeException;
}