package com.kasun.run;

import com.kasun.userapp.dto.ObjectID;
import com.kasun.userapp.logic.Calculation;
import com.kasun.userapp.logic.ReadingXLLogic;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by kasun on 6/20/15.
 */
public class MainClass {

    public static void main(String args []){

        BigDecimal upperValueSecondPart = BigDecimal.TEN.scaleByPowerOfTen(6);
        ReadingXLLogic readingXLLogic = new ReadingXLLogic();
        List<ObjectID> tables = readingXLLogic.getAllTheTablesAsList();
        Calculation calculation = new Calculation();
        Map<String , List<BigDecimal>> pValuesAndPowerPlantValues = calculation.calculatePValuesAndValueOfPowerPlant(tables);
        printCalculatedValues(pValuesAndPowerPlantValues);

    }


    private static void printCalculatedValues(Map<String, List<BigDecimal>> pValuesAndPowerPlantValues) {

        for(Map.Entry<String, List<BigDecimal>> entry : pValuesAndPowerPlantValues.entrySet()){
            System.out.print("Table Number : "+entry.getKey()+" ");

            for(BigDecimal value : entry.getValue()){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}