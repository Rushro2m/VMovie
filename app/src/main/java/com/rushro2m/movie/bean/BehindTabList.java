package com.rushro2m.movie.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BehindTabList {

    /**
     * status : 0
     * msg : OK
     * data : [{"cateid":"2","catename":"全部"},{"cateid":"47","catename":"电影自习室"},{"cateid":"53","catename":"电影会客厅"},{"cateid":"4","catename":"拍摄"},{"cateid":"31","catename":"器材"},{"cateid":"80","catename":"VR"},{"cateid":"30","catename":"后期"},{"cateid":"26","catename":"综述"}]
     */

    private String status;
    private String msg;
    private List<BehindTabData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<BehindTabData> getData() {
        return data;
    }

    public void setData(List<BehindTabData> data) {
        this.data = data;
    }

    public static class BehindTabData {
        /**
         * cateid : 2
         * catename : 全部
         */

        private String cateid;
        private String catename;

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
    }
}
