package com.kevin.app.base.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kevin.app.R;
import com.kevin.app.module.profit.model.ProfitResultModel;

import java.util.List;

/**
 * @author kevin on 2017/11/1.
 */
public class MyPremiumAdapter extends BaseQuickAdapter<ProfitResultModel.RowsBean, BaseViewHolder> {
    private Context context;
    public MyPremiumAdapter(List<ProfitResultModel.RowsBean> data, Context context) {
        super(R.layout.item_list_my_detail, data);
        this.context = context;
    }
    @Override
    protected void convert(BaseViewHolder helper, final ProfitResultModel.RowsBean item) {
        helper.setText(R.id.tv_premium_date,item.getYear()+"年"+item.getMonth()+"月");
        helper.setText(R.id.tv_premium_total,String.format(context.getResources().getString(R.string.price_value_unit),(double)item.getIncome()/100));
        RecyclerView recyclerProductDetail = helper.getView(R.id.recycler_view_product_detail);
        recyclerProductDetail.setLayoutManager(new LinearLayoutManager(context));
        recyclerProductDetail.addItemDecoration(new MyItemDecoration(context,MyItemDecoration.VERTICAL_LIST));
        List<ProfitResultModel.RowsBean.PerProductBean> list = item.getPer_product();
        if (list != null && list.size() > 0) {
            recyclerProductDetail.setAdapter(new BaseQuickAdapter(R.layout.item_list_product_detail, list) {

                @Override
                protected void convert(BaseViewHolder helper,Object object) {
                    ProfitResultModel.RowsBean.PerProductBean bean = (ProfitResultModel.RowsBean.PerProductBean) object;
                    helper.setText(R.id.tv_product_name,bean.getProduct_text());
                    helper.setText(R.id.tv_product_price,String.format(context.getResources().getString(R.string.price_value_unit),(double)bean.getPer_product_income()/100));
                }
            });
        }
    }
}