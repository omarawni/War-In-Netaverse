package cwk4.src.cwk4;
/*
Class for general tests (For testing functionality of all classes, and for individuals to verify the veracity of their code.)
 */
import java.io.IOException;

public class general_tests {
    public static void main(String[] args) throws IOException {
        WIN game = new SpaceWars("John", "battles.txt");
        //System.out.println (game.getAllForces());

        /*
        Refutation of the result of recallingDestroyedInFightForceDoesntAffectWarchestOnReactivation() in T4BattleTest:
         */
        //game.activateForce("IW1");
        //game.doBattle(2);
        //game.activateForce("IW1");
        //System.out.println (game.getWarchest());


        /*
        Refutation of the result of reactivateExistingForceHasNoEffectOnWarchest() in T3ForceActivationTest:
         */
        game.activateForce("IW1");
        game.activateForce("SS2");
        game.activateForce("IW1");
        System.out.println(game.getDestroyedForces());
        System.out.println (game.getWarchest());
        game.saveGame("CurrentSave.txt");




    }
}
