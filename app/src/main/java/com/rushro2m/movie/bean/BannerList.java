package com.rushro2m.movie.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */

public class BannerList {

    /**
     * status : 0
     * msg : OK
     * data : [{"bannerid":"1886","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/07/11/59645789d2c47.jpg","description":"","userid":"10001114","addtime":"1499748235","uptime":"1499748235","orderid":"7","cateid":"0","count_click":"3794","status":"1","start_time":"1499748233","end_time":"0","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"52132\",\"app_show_type\":null}","extra_data":{"app_banner_type":"2","app_banner_param":"52132","app_show_type":"","is_album":"0"}},{"bannerid":"1893","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/07/18/596dba85d2ee8.jpg","description":"","userid":"10001114","addtime":"1500375899","uptime":"1500375899","orderid":"6","cateid":"0","count_click":"708","status":"1","start_time":"1500363360","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/www.vmovier.com\\/activity\\/200?from=activity_all\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"http://www.vmovier.com/activity/200?from=activity_all","app_show_type":"all"}},{"bannerid":"1889","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/07/12/5965c75090151.png","description":"","userid":"10000002","addtime":"1499842397","uptime":"1499842397","orderid":"5","cateid":"0","count_click":"1119","status":"1","start_time":"1499842384","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/www.xinpianchang.com\\/activity\\/independence\\/ts-juvenile\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"http://www.xinpianchang.com/activity/independence/ts-juvenile","app_show_type":"all"}},{"bannerid":"1883","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/07/06/595e1abd1fe58.jpg","description":"","userid":"927555","addtime":"1499339457","uptime":"1499339457","orderid":"4","cateid":"0","count_click":"2857","status":"1","start_time":"1499339452","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/www.vmovier.com\\/activity\\/192\",\"app_show_type\":null}","extra_data":{"app_banner_type":"1","app_banner_param":"http://www.vmovier.com/activity/192","app_show_type":""}},{"bannerid":"1885","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/07/11/596457649a2fe.jpg","description":"","userid":"10001114","addtime":"1499748198","uptime":"1499748198","orderid":"3","cateid":"0","count_click":"1226","status":"1","start_time":"1499748196","end_time":"0","extra":"{\"app_banner_type\":\"2\",\"app_banner_param\":\"52104\",\"app_show_type\":null}","extra_data":{"app_banner_type":"2","app_banner_param":"52104","app_show_type":"","is_album":"0"}},{"bannerid":"1853","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/06/23/594d1b591a817.jpg","description":"","userid":"551913","addtime":"1498225497","uptime":"1498225497","orderid":"2","cateid":"0","count_click":"1984","status":"1","start_time":"1498142520","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/www.xinpianchang.com\\/activity\\/filmfest\\/ts-filmfest?inner_app=1\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"http://www.xinpianchang.com/activity/filmfest/ts-filmfest?inner_app=1","app_show_type":"all"}},{"bannerid":"1769","type":"7","object_id":"0","title":"","url":"/","image":"http://cs.vmoiver.com/Uploads/Banner/2017/06/21/594a55a066c64.png","description":"","userid":"962854","addtime":"1498043808","uptime":"1498043808","orderid":"1","cateid":"0","count_click":"6875","status":"1","start_time":"1495803720","end_time":"0","extra":"{\"app_banner_type\":\"1\",\"app_banner_param\":\"http:\\/\\/school.xinpianchang.com\\/film-room\\/application\\/phenom_films_m.html?id=2&agency_id=26\",\"app_show_type\":\"all\"}","extra_data":{"app_banner_type":"1","app_banner_param":"http://school.xinpianchang.com/film-room/application/phenom_films_m.html?id=2&agency_id=26","app_show_type":"all"}}]
     */

    private String status;
    private String msg;
    private List<BannerData> data;

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

    public List<BannerData> getData() {
        return data;
    }

    public void setData(List<BannerData> data) {
        this.data = data;
    }

    public static class BannerData {
        /**
         * bannerid : 1886
         * type : 7
         * object_id : 0
         * title :
         * url : /
         * image : http://cs.vmoiver.com/Uploads/Banner/2017/07/11/59645789d2c47.jpg
         * description :
         * userid : 10001114
         * addtime : 1499748235
         * uptime : 1499748235
         * orderid : 7
         * cateid : 0
         * count_click : 3794
         * status : 1
         * start_time : 1499748233
         * end_time : 0
         * extra : {"app_banner_type":"2","app_banner_param":"52132","app_show_type":null}
         * extra_data : {"app_banner_type":"2","app_banner_param":"52132","app_show_type":"","is_album":"0"}
         */

        private String bannerid;
        private String type;
        private String object_id;
        private String title;
        private String url;
        private String image;
        private String description;
        private String userid;
        private String addtime;
        private String uptime;
        private String orderid;
        private String cateid;
        private String count_click;
        private String status;
        private String start_time;
        private String end_time;
        private String extra;
        private ExtraDataBean extra_data;

        public String getBannerid() {
            return bannerid;
        }

        public void setBannerid(String bannerid) {
            this.bannerid = bannerid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
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

        public String getCount_click() {
            return count_click;
        }

        public void setCount_click(String count_click) {
            this.count_click = count_click;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }

        public ExtraDataBean getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(ExtraDataBean extra_data) {
            this.extra_data = extra_data;
        }

        public static class ExtraDataBean {
            /**
             * app_banner_type : 2
             * app_banner_param : 52132
             * app_show_type :
             * is_album : 0
             */

            private String app_banner_type;
            private String app_banner_param;
            private String app_show_type;
            private String is_album;

            public String getApp_banner_type() {
                return app_banner_type;
            }

            public void setApp_banner_type(String app_banner_type) {
                this.app_banner_type = app_banner_type;
            }

            public String getApp_banner_param() {
                return app_banner_param;
            }

            public void setApp_banner_param(String app_banner_param) {
                this.app_banner_param = app_banner_param;
            }

            public String getApp_show_type() {
                return app_show_type;
            }

            public void setApp_show_type(String app_show_type) {
                this.app_show_type = app_show_type;
            }

            public String getIs_album() {
                return is_album;
            }

            public void setIs_album(String is_album) {
                this.is_album = is_album;
            }
        }
    }
}
