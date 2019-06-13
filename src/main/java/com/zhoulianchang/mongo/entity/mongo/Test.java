package com.zhoulianchang.mongo.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author zlc
 * @date 2019-06-13 11:56
 */
@Document(collection = "test")
public class Test {

    /**
     * _id : 5cff7f222abefc1d5e3156f7
     * info : {"ConfQos":{"sendBr":"52","audioLevel":"1","audioSendBr":"2","localActor":"[username:hdhdhd@100167.cloud.justalk.com]","sendBWE":"1224","sendLossRate":"0","cpuTLoad":"0","recvJitter":"0","rtt":"2","cpuPLoad":"0","recvLossRate":"0","sendJitter":"0","recvBWE":"2274","videoSendBr":"54","recvBr":"558"},"ConfQoe":{"remoteactor":[{"videoRenderFPS":"11","videoRecvH":"648","videoSubW":"640","audioRecvBr":"18","videoTmos":"3.6884","videoRecvW":"368","videoPmos":"4.32405","audioTmos":"2.92356","videoSubH":"360","actorId":"[username:2e9b3d46f6994b16948b01758bc8fde9_test@100167.cloud.justalk.com]","videoRecvBr":"505"},{"videoRenderFPS":"11","videoRecvH":"648","videoSubW":"640","audioRecvBr":"18","videoTmos":"3.6884","videoRecvW":"368","videoPmos":"4.32405","audioTmos":"2.92356","videoSubH":"360","actorId":"[username:delivery_10424696_1560247247396_10@100074.cloud.justalk.com]","videoRecvBr":"505"}]},"Common":{"timestamp":"1560248087995","token":"10424696-2019061117h59m57s-6"},"ConfAttr":{"conf_num":"10424696","room_id":"102252360302631","uri":"jsmi://102252360302631?directJsmiId=#1CB63F5392ECCD6E:sarc -h 2 -p 12187;&confNum=10424696&title=10086&video=1&viewmode=1&vidquality=1&vidsquare=0&security=1&privateToken=","role_type":"JSM"}}
     * time : 1.56024809842088E9
     */

    @Id
    private String _id;
    private InfoBean info;
    private double time;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public static class InfoBean {
        /**
         * ConfQos : {"sendBr":"52","audioLevel":"1","audioSendBr":"2","localActor":"[username:hdhdhd@100167.cloud.justalk.com]","sendBWE":"1224","sendLossRate":"0","cpuTLoad":"0","recvJitter":"0","rtt":"2","cpuPLoad":"0","recvLossRate":"0","sendJitter":"0","recvBWE":"2274","videoSendBr":"54","recvBr":"558"}
         * ConfQoe : {"remoteactor":[{"videoRenderFPS":"11","videoRecvH":"648","videoSubW":"640","audioRecvBr":"18","videoTmos":"3.6884","videoRecvW":"368","videoPmos":"4.32405","audioTmos":"2.92356","videoSubH":"360","actorId":"[username:2e9b3d46f6994b16948b01758bc8fde9_test@100167.cloud.justalk.com]","videoRecvBr":"505"},{"videoRenderFPS":"11","videoRecvH":"648","videoSubW":"640","audioRecvBr":"18","videoTmos":"3.6884","videoRecvW":"368","videoPmos":"4.32405","audioTmos":"2.92356","videoSubH":"360","actorId":"[username:delivery_10424696_1560247247396_10@100074.cloud.justalk.com]","videoRecvBr":"505"}]}
         * Common : {"timestamp":"1560248087995","token":"10424696-2019061117h59m57s-6"}
         * ConfAttr : {"conf_num":"10424696","room_id":"102252360302631","uri":"jsmi://102252360302631?directJsmiId=#1CB63F5392ECCD6E:sarc -h 2 -p 12187;&confNum=10424696&title=10086&video=1&viewmode=1&vidquality=1&vidsquare=0&security=1&privateToken=","role_type":"JSM"}
         */

        private ConfQosBean ConfQos;
        private ConfQoeBean ConfQoe;
        private CommonBean Common;
        private ConfAttrBean ConfAttr;

        public ConfQosBean getConfQos() {
            return ConfQos;
        }

        public void setConfQos(ConfQosBean ConfQos) {
            this.ConfQos = ConfQos;
        }

        public ConfQoeBean getConfQoe() {
            return ConfQoe;
        }

        public void setConfQoe(ConfQoeBean ConfQoe) {
            this.ConfQoe = ConfQoe;
        }

        public CommonBean getCommon() {
            return Common;
        }

        public void setCommon(CommonBean Common) {
            this.Common = Common;
        }

        public ConfAttrBean getConfAttr() {
            return ConfAttr;
        }

        public void setConfAttr(ConfAttrBean ConfAttr) {
            this.ConfAttr = ConfAttr;
        }

        public static class ConfQosBean {
            /**
             * sendBr : 52
             * audioLevel : 1
             * audioSendBr : 2
             * localActor : [username:hdhdhd@100167.cloud.justalk.com]
             * sendBWE : 1224
             * sendLossRate : 0
             * cpuTLoad : 0
             * recvJitter : 0
             * rtt : 2
             * cpuPLoad : 0
             * recvLossRate : 0
             * sendJitter : 0
             * recvBWE : 2274
             * videoSendBr : 54
             * recvBr : 558
             */

            private String sendBr;
            private String audioLevel;
            private String audioSendBr;
            private String localActor;
            private String sendBWE;
            private String sendLossRate;
            private String cpuTLoad;
            private String recvJitter;
            private String rtt;
            private String cpuPLoad;
            private String recvLossRate;
            private String sendJitter;
            private String recvBWE;
            private String videoSendBr;
            private String recvBr;

            public String getSendBr() {
                return sendBr;
            }

            public void setSendBr(String sendBr) {
                this.sendBr = sendBr;
            }

            public String getAudioLevel() {
                return audioLevel;
            }

            public void setAudioLevel(String audioLevel) {
                this.audioLevel = audioLevel;
            }

            public String getAudioSendBr() {
                return audioSendBr;
            }

            public void setAudioSendBr(String audioSendBr) {
                this.audioSendBr = audioSendBr;
            }

            public String getLocalActor() {
                return localActor;
            }

            public void setLocalActor(String localActor) {
                this.localActor = localActor;
            }

            public String getSendBWE() {
                return sendBWE;
            }

            public void setSendBWE(String sendBWE) {
                this.sendBWE = sendBWE;
            }

            public String getSendLossRate() {
                return sendLossRate;
            }

            public void setSendLossRate(String sendLossRate) {
                this.sendLossRate = sendLossRate;
            }

            public String getCpuTLoad() {
                return cpuTLoad;
            }

            public void setCpuTLoad(String cpuTLoad) {
                this.cpuTLoad = cpuTLoad;
            }

            public String getRecvJitter() {
                return recvJitter;
            }

            public void setRecvJitter(String recvJitter) {
                this.recvJitter = recvJitter;
            }

            public String getRtt() {
                return rtt;
            }

            public void setRtt(String rtt) {
                this.rtt = rtt;
            }

            public String getCpuPLoad() {
                return cpuPLoad;
            }

            public void setCpuPLoad(String cpuPLoad) {
                this.cpuPLoad = cpuPLoad;
            }

            public String getRecvLossRate() {
                return recvLossRate;
            }

            public void setRecvLossRate(String recvLossRate) {
                this.recvLossRate = recvLossRate;
            }

            public String getSendJitter() {
                return sendJitter;
            }

            public void setSendJitter(String sendJitter) {
                this.sendJitter = sendJitter;
            }

            public String getRecvBWE() {
                return recvBWE;
            }

            public void setRecvBWE(String recvBWE) {
                this.recvBWE = recvBWE;
            }

            public String getVideoSendBr() {
                return videoSendBr;
            }

            public void setVideoSendBr(String videoSendBr) {
                this.videoSendBr = videoSendBr;
            }

            public String getRecvBr() {
                return recvBr;
            }

            public void setRecvBr(String recvBr) {
                this.recvBr = recvBr;
            }
        }

        public static class ConfQoeBean {
            private List<RemoteactorBean> remoteactor;

            public List<RemoteactorBean> getRemoteactor() {
                return remoteactor;
            }

            public void setRemoteactor(List<RemoteactorBean> remoteactor) {
                this.remoteactor = remoteactor;
            }

            public static class RemoteactorBean {
                /**
                 * videoRenderFPS : 11
                 * videoRecvH : 648
                 * videoSubW : 640
                 * audioRecvBr : 18
                 * videoTmos : 3.6884
                 * videoRecvW : 368
                 * videoPmos : 4.32405
                 * audioTmos : 2.92356
                 * videoSubH : 360
                 * actorId : [username:2e9b3d46f6994b16948b01758bc8fde9_test@100167.cloud.justalk.com]
                 * videoRecvBr : 505
                 */

                private String videoRenderFPS;
                private String videoRecvH;
                private String videoSubW;
                private String audioRecvBr;
                private String videoTmos;
                private String videoRecvW;
                private String videoPmos;
                private String audioTmos;
                private String videoSubH;
                private String actorId;
                private String videoRecvBr;

                public String getVideoRenderFPS() {
                    return videoRenderFPS;
                }

                public void setVideoRenderFPS(String videoRenderFPS) {
                    this.videoRenderFPS = videoRenderFPS;
                }

                public String getVideoRecvH() {
                    return videoRecvH;
                }

                public void setVideoRecvH(String videoRecvH) {
                    this.videoRecvH = videoRecvH;
                }

                public String getVideoSubW() {
                    return videoSubW;
                }

                public void setVideoSubW(String videoSubW) {
                    this.videoSubW = videoSubW;
                }

                public String getAudioRecvBr() {
                    return audioRecvBr;
                }

                public void setAudioRecvBr(String audioRecvBr) {
                    this.audioRecvBr = audioRecvBr;
                }

                public String getVideoTmos() {
                    return videoTmos;
                }

                public void setVideoTmos(String videoTmos) {
                    this.videoTmos = videoTmos;
                }

                public String getVideoRecvW() {
                    return videoRecvW;
                }

                public void setVideoRecvW(String videoRecvW) {
                    this.videoRecvW = videoRecvW;
                }

                public String getVideoPmos() {
                    return videoPmos;
                }

                public void setVideoPmos(String videoPmos) {
                    this.videoPmos = videoPmos;
                }

                public String getAudioTmos() {
                    return audioTmos;
                }

                public void setAudioTmos(String audioTmos) {
                    this.audioTmos = audioTmos;
                }

                public String getVideoSubH() {
                    return videoSubH;
                }

                public void setVideoSubH(String videoSubH) {
                    this.videoSubH = videoSubH;
                }

                public String getActorId() {
                    return actorId;
                }

                public void setActorId(String actorId) {
                    this.actorId = actorId;
                }

                public String getVideoRecvBr() {
                    return videoRecvBr;
                }

                public void setVideoRecvBr(String videoRecvBr) {
                    this.videoRecvBr = videoRecvBr;
                }
            }
        }

        public static class CommonBean {
            /**
             * timestamp : 1560248087995
             * token : 10424696-2019061117h59m57s-6
             */

            private String timestamp;
            private String token;

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }
        }

        public static class ConfAttrBean {
            /**
             * conf_num : 10424696
             * room_id : 102252360302631
             * uri : jsmi://102252360302631?directJsmiId=#1CB63F5392ECCD6E:sarc -h 2 -p 12187;&confNum=10424696&title=10086&video=1&viewmode=1&vidquality=1&vidsquare=0&security=1&privateToken=
             * role_type : JSM
             */

            private String conf_num;
            private String room_id;
            private String uri;
            private String role_type;

            public String getConf_num() {
                return conf_num;
            }

            public void setConf_num(String conf_num) {
                this.conf_num = conf_num;
            }

            public String getRoom_id() {
                return room_id;
            }

            public void setRoom_id(String room_id) {
                this.room_id = room_id;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getRole_type() {
                return role_type;
            }

            public void setRole_type(String role_type) {
                this.role_type = role_type;
            }
        }
    }
}
