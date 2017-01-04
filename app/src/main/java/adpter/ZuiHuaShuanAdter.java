package adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import activity.zhidemaiactivity.ZhiDeMaiActivity;
import bean.ZuiYouHuiBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import xiangcuntiandi.quanmather.R;

/**
 * Created by Administrator on 2016/12/28.
 */

public class ZuiHuaShuanAdter extends RecyclerView.Adapter<ZuiHuaShuanAdter.MyViewHolder> {

    private final Context context;
    private List<ZuiYouHuiBean.DataBean.RowsBean> dataList;

    public ZuiHuaShuanAdter(Context context){
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.zuihuasuan_item, parent, false));
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
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


    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.imv_brand)
            ImageView imvBrand;
            @BindView(R.id.tv_name)
            TextView tvName;
            @BindView(R.id.tv_price)
            TextView tvPrice;
            @BindView(R.id.imv_icon)
            ImageView imvIcon;
            @BindView(R.id.guanzhushu)
            TextView guanzhushu;
        @BindView(R.id.name_goods)
        TextView namegoods;
        @BindView(R.id.rv)
        RelativeLayout linearLayout;
        public  MyViewHolder(View view) {
           super(view);
           ButterKnife.bind(this, view);
         }
    }
    @Override
    public int getItemCount() {
        return (dataList == null || dataList.size() == 0) ? 0 : dataList.size();
    }

    public void setData(List<ZuiYouHuiBean.DataBean.RowsBean> dataList) {
        this.dataList = dataList;

    }


}
