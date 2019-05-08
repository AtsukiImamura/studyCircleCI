/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package janken;

import org.junit.Test;

import janken.constants.JankenHand;
import janken.constants.JankenJudgement;
import janken.manager.JankenImpl;

import static org.junit.Assert.*;

public class AppTest {
    /**
     * じゃんけんの確率をチェック
     */
    @Test public void testHandProb() {
        JankenImpl janken = new JankenImpl();
        int checkNum = 100;
        int winCnt = 0;
        int drawCnt = 0;
        int roseCnt = 0;

        while(winCnt + drawCnt + roseCnt < checkNum){
            try{
                int result = janken.janken(JankenHand.PAPER);
                switch(result){
                    case JankenJudgement.WIN:
                        winCnt++;
                        break;
                    case JankenJudgement.DRAW:
                        drawCnt++;
                        break;
                    case JankenJudgement.ROSE:
                        roseCnt++;
                        break;
                }
            }catch(Exception e){
                assertNotNull("Error on invoking janken method.", null);
            }
        }

        assertTrue("Probability of win must be between 0.25 and 0.40", winCnt > 0.25 && winCnt < 0.40);
        assertTrue("Probability of draw must be between 0.25 and 0.40", drawCnt > 0.25 && drawCnt < 0.40);
        assertTrue("Probability of rose must be between 0.25 and 0.40", roseCnt > 0.25 && roseCnt < 0.40);
    }
}
