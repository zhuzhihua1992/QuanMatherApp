package adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;

import java.util.List;

import activity.zhidemaiactivity.ZhiDeMaiActivity;
import bean.BrandDetailBean;
import bean.ZuiYouHuiBean;
import xiangcuntiandi.quanmather.R;

/**
 * Created by Administrator on 2016/12/31.
 */

public class BrandDetailAdter extends SuperBaseAdapter<BrandDetailBean.DataBean.PostlistBean> {
     Context context;
    public BrandDetailAdter(Context context, List<BrandDetailBean.DataBean.PostlistBean> data) {
        super(context, data);
        this.context=context;
        recAdter=new BrandDetailRecAdter(context);
    }
     BrandDetailRecAdter recAdter;
    @Override
    protected void convert(BaseViewHolder holder, BrandDetailBean.DataBean.PostlistBean item, int position) {
        holder.setText(R.id.tv_detail_tital,item.getYouhuitypename());
        RecyclerView recyclerView= (RecyclerView)holder.getView(R.id.rv_detail);
        List<BrandDetailBean.DataBean.PostlistBean.ItemsBean> items = item.getItems();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recAdter);
        recAdter.setData(items);
    }

    @Override
    protected int getItemViewLayoutId(int position, BrandDetailBean.DataBean.PostlistBean item) {
        return R.layout.branddetail_item;
    }



    /*  @Override
    protected void convert(BaseViewHolder holder, final ZuiYouHuiBean.DataBean.RowsBean item, int position) {
       Glide.with(context).load(item.getArticle_pic()).into((ImageView)holder.getView(R.id.imv_brand));
        Glide.with(context).load(item.getArticle_mall_icon2()).diskCacheStrategy(DiskCacheStrategy.ALL).into((ImageView)holder.getView(R.id.imv_icon));
        holder.setText(R.id.tv_name,item.getArticle_simpletitle());
        holder.setText(R.id.tv_price,item.getArticle_vicetitle());
        holder.setText(R.id.name_goods,item.getArticle_mall());
        holder.setText(R.id.guanzhushu,"查看人数： "+item.getArticle_read_count());

        holder.setOnClickListener(R.id.rv, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ZhiDeMaiActivity.class);
                int article_id = item.getArticle_id();
                Log.e("at22",article_id+"");
                intent.putExtra("goodsId",item.getArticle_id());
                context.startActivity(intent);
            }
        });
    }*/
/*
    Glide.with(context).load(dataList.get(position).getArticle_pic()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imvBrand);
        Glide.with(context).load(dataList.get(position).getArticle_mall_icon2()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imvIcon);
        holder.tvName.setText(dataList.get(position).getArticle_simpletitle());
        holder.tvPrice.setText(dataList.get(position).getArticle_vicetitle());
        holder.namegoods.setText(dataList.get(position).getArticle_mall());
        holder.guanzhushu.setText("查看人数： "+dataList.get(position).getArticle_read_count());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ZhiDeMaiActivity.class);
                int article_id = dataList.get(position).getArticle_id();
                Log.e("at22",article_id+"");
                intent.putExtra("goodsId",dataList.get(position).getArticle_id());
                context.startActivity(intent);
            }
        });
 */

    /**
     * @param position
     * @param item
     * @return
     * @BindView(R.id.imv_brand) ImageView imvBrand;
     * @BindView(R.id.tv_name) TextView tvName;
     * @BindView(R.id.tv_price) TextView tvPrice;
     * @BindView(R.id.imv_icon) ImageView imvIcon;
     * @BindView(R.id.guanzhushu) TextView guanzhushu;
     * @BindView(R.id.name_goods) TextView namegoods;
     * @BindView(R.id.rv) RelativeLayout linearLayout;
     */

}
