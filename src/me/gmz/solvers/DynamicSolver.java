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

        int weight = (int)(backpackWeight*10);
        float[][] M = new float[data.size()][weight+1];

        for(int j = 0; j < weight+1; j++){ //Filling the first line of the array
            if((int)(data.get(0).getWeight()*10) > j)
                M[0][j] = 0;
            else
                M[0][j] = data.get(0).getValue();
        }

        for(int i = 1; i < data.size(); ++i){ //Filling the remaining lines
            for(int j = 0; j < weight+1; ++j){
                if((int)(data.get(i).getWeight()*10) > j)
                    M[i][j] = M[i-1][j];
                else
                    M[i][j] = Math.max(M[i-1][j], M[i-1][j-(int)(data.get(i).getWeight()*10)] + data.get(i).getValue());
            }
        }

        //Now that the matrix is filled, we can find the best solution and deduce the items
        int i = data.size() - 1;
        int j = weight;

        while(M[i][j] == M[i][j-1])
            j--;

        while(j > 0){
            while(i > 0 && M[i][j] == M[i-1][j]){
                i--;
            }
            j = j - (int)(data.get(i).getWeight()*10);
            if(j >= 0){
                try {
                    result.addItem(data.get(i));
                }catch (ItemCannotBeAddedException e) {
                    
                }
            }
            i--;
        }
        //2 4 5 7 8
        return result;
    }
}
