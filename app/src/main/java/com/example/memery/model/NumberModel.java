package com.example.memery.model;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2017/1/19.
 */
@Table(name = "NumberModel")
public class NumberModel {

    @Column(name = "num",isId = true,autoGen = false)
     int num;
    @Column(name = "remarks",autoGen = false)
    String remarks;
    public int getNum() {


        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }






    static NumberModel numberModel = new NumberModel();

    public static NumberModel GetNumberModel(int num) {
        numberModel.setNum(num);
        return numberModel;
    }

    public static NumberModel GetNumberModel(String num) {

        return GetNumberModel(Integer.parseInt(num));
    }
}
