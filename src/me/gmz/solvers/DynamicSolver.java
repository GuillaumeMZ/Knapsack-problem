package me.gmz.solvers;

import me.gmz.Backpack;
import me.gmz.ISolver;
import me.gmz.Item;
import me.gmz.ItemCannotBeAddedException;

import java.util.ArrayList;

public class DynamicSolver implements ISolver {
    @Override
    public Backpack solve(ArrayList<Item> data, float backpackWeight) {
        Backpack result = new Backpack(backpackWeight);

        int[][] M = new int[data.size()][(int)backpackWeight+1];

        for(int j = 0; j < backpackWeight+1; j++){ //Filling the first line of the array
            if((int)(data.get(0).getWeight()) > j)
                M[0][j] = 0;
            else
                M[0][j] = (int)data.get(0).getValue();
        }

        for(int i = 1; i < data.size(); ++i){ //Filling the remaining lines
            for(int j = 0; j < (int)backpackWeight+1; ++j){
                if((int)(data.get(i).getWeight()) > j)
                    M[i][j] = M[i-1][j];
                else
                    M[i][j] = Math.max(M[i-1][j], M[i-1][j-(int)(data.get(i).getWeight())] + (int)data.get(i).getValue());
            }
        }

        //Now that the matrix is filled, we can find the best solution and deduce the items
        int i = data.size() - 1;
        int j = (int)backpackWeight;

        while(M[i][j] == M[i][j-1])
            j--;

        while(j > 0){
            while(i > 0 && M[i][j] == M[i-1][j]){
                i--;
            }
            j = j - (int)(data.get(i).getWeight());
            if(j >= 0){
                try {
                    result.addItem(data.get(i));
                }catch (ItemCannotBeAddedException e) {
                    System.out.println("item " + i + " non ajouté");
                }
            }
            i--;
        }
        //2 4 5 7 8
        return result;
    }
}
