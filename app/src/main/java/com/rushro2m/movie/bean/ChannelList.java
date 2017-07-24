package com.rushro2m.movie.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class ChannelList {

    private List<ChannelData> data;

    public List<ChannelData> getData() {
        return data;
    }

    public void setData(List<ChannelData> data) {
        this.data = data;
    }

    public static class ChannelData {
        /**
         * cate_type : 0
         * orderid : 1
         * cateid : 6
         * catename : 创意
         * alias : Idea
         * icon : http://cs.vmoiver.com/Uploads/Series/2017-06-22/594b9e1cb1f1b.jpg
         */

        private String cate_type;
        private String orderid;
        private String cateid;
        private String catename;
        private String alias;
        private String icon;

        public String getCate_type() {
            return cate_type;
        }

        public void setCate_type(String cate_type) {
            this.cate_type = cate_type;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getCateid() {
            return cateid;
        }

        public void setCateid(String cateid) {
            this.cateid = cateid;
        }

        public String getCatename() {
            return catename;
        }

        public void setCatename(String catename) {
            this.catename = catename;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
