package me.gmz;

import me.gmz.backpack.Backpack;
import me.gmz.backpack.Item;
import me.gmz.readers.FileDataReader;
import me.gmz.solvers.BranchAndBoundSolver;
import me.gmz.solvers.DynamicSolver;
import me.gmz.solvers.NaiveSolver;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //args: chemin poids_maximal méthode
        assert args.length == 3 : "There is not enough arguments !"; //TODO switch to a if + exception
        String filePath = args[0];
        //float backpack_weight = Float.parseFloat(args[1]); //TODO check validity
        float backpack_weight = 150;
        //String algorithm = args[2];

        FileDataReader dataReader = new FileDataReader(filePath);
        ArrayList<Item> items = dataReader.readData();

        Backpack backpack = new BranchAndBoundSolver().solve(items, backpack_weight);
        System.out.println(backpack);
    }
}
