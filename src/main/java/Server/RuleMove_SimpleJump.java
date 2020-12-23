package Server;

import static java.lang.Math.abs;
import static java.lang.Math.floor;

public class RuleMove_SimpleJump extends RuleMove{


    RuleMove_SimpleJump(serverHead head, LogicBoard board) {
        super(head, board);
    }

    private boolean isBeetwen(int closeToCheck){
        for(String color: head.colors){
            if(color.equals(board.getFieldColor(head.getCurrentX()-(head.getCurrentX()-new_x)/2,closeToCheck))){
                System.out.println("Done " + this.getClass().getSimpleName());
                doMove();
                return true;
            }
        }
        System.out.println("Failed " + this.getClass().getSimpleName());
        return false;
    }

    @Override
    protected boolean canDo(Player player) {
        System.out.println("Try " + this.getClass().getSimpleName());

        if(board.getFieldColor(new_x, new_y).equals("white")){
            if(head.getCurrentX() % 2 == 0){
                if(new_x == head.getCurrentX()) {
                    if (head.getCurrentY() - new_y == 2) {
                        return isBeetwen(head.getCurrentY() - 1);
                    } else if (head.getCurrentY() - new_y == -2) {
                        return isBeetwen(head.getCurrentY() + 1);
                    }
                } else if (head.getCurrentX() - new_x == 2 || head.getCurrentX() - new_x == -2) {
                    if(head.getCurrentY() - new_y == 1){
                        return isBeetwen(head.getCurrentY());
                    }else if(head.getCurrentY() - new_y == -1){
                        return isBeetwen(head.getCurrentY()+1);
                    }
                }
            } else {
                if(new_x == head.getCurrentX()) {
                    if (head.getCurrentY() - new_y == 2) {
                        return isBeetwen(head.getCurrentY() );
                    } else if (head.getCurrentY() - new_y == -2) {
                        return isBeetwen(head.getCurrentY());
                    }
                } else if (head.getCurrentX() - new_x == 2 || head.getCurrentX() - new_x == -2) {
                    if (head.getCurrentY() - new_y == 1) {
                        return isBeetwen(head.getCurrentY() - 1);
                    } else if (head.getCurrentY() - new_y == -1) {
                        return isBeetwen(head.getCurrentY());
                    }
                }
            }
        }








        return false;
    }
}


