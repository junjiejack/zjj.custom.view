package com.kevin.app.module.profit.model;

import java.util.List;

/**
 * Created by zhoujunjie on 2018/3/26.
 */
public class ProfitResultModel {


    /**
     * err_code : 0
     * err_msg
     * rows : [{"year":2017,"month":11,"income":6775,"per_product":[{"product_id":2,"product_text":"聚保整车保","per_product_income":3775},{"product_id":4,"product_text":"聚保员工保","per_product_income":3000}]},{"year":2017,"month":10,"income":11109,"per_product":[{"product_id":2,"product_text":"聚保整车保","per_product_income":3759},{"product_id":4,"product_text":"聚保员工保","per_product_income":3675},{"product_id":16,"product_text":"聚保商铺保","per_product_income":3675}]}]
     * total : 2
     */

    private int err_code;
    private String err_msg;
    private int total;
    private List<RowsBean> rows;

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * year : 2017
         * month : 11
         * income : 6775
         * per_product : [{"product_id":2,"product_text":"聚保整车保","per_product_income":3775},{"product_id":4,"product_text":"聚保员工保","per_product_income":3000}]
         */

        private int year;
        private int month;
        private int income;
        private List<PerProductBean> per_product;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getIncome() {
            return income;
        }

        public void setIncome(int income) {
            this.income = income;
        }

        public List<PerProductBean> getPer_product() {
            return per_product;
        }

        public void setPer_product(List<PerProductBean> per_product) {
            this.per_product = per_product;
        }

        public static class PerProductBean {
            /**
             * product_id : 2
             * product_text : 聚保整车保
             * per_product_income : 3775
             */

            private int product_id;
            private String product_text;
            private int per_product_income;

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public String getProduct_text() {
                return product_text;
            }

            public void setProduct_text(String product_text) {
                this.product_text = product_text;
            }

            public int getPer_product_income() {
                return per_product_income;
            }

            public void setPer_product_income(int per_product_income) {
                this.per_product_income = per_product_income;
            }
        }
    }
}
