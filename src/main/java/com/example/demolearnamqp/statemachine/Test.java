package com.example.demolearnamqp.statemachine;

import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void main(String[] args) {

//        WorkOrderStateMachine mario = new WorkOrderStateMachine();
//        System.out.println(String.valueOf(mario.getPreviousState().getName()) + "  -----  " + String.valueOf(mario.getCurrentState().getName()));
//        mario.administratorSuspendOperation();
//        System.out.println(String.valueOf(mario.getPreviousState().getName()) + "  -----  " + String.valueOf(mario.getCurrentState().getName()));
//        mario.administratorUnhook();
//        System.out.println(String.valueOf(mario.getPreviousState().getName()) + "  -----  " + String.valueOf(mario.getCurrentState().getName()));


        String info = "{\n" +
                "    \"createTime\":1594719312956,\n" +
                "    \"data\":{\n" +
                "        \"account\":\"xxx\",\n" +
                "        \"accountName\":\"asdasdasdasd\",\n" +
                "        \"callStatus\":2,\n" +
                "        \"callTime\":\"2020-07-14 17:29:12\",\n" +
                "        \"channelType\":\"已分配来电\",\n" +
                "        \"connect\":false,\n" +
                "        \"customerState\":1,\n" +
                "        \"duration\":0,\n" +
                "        \"fileName\":\"http://ig-ivr.oss-cn-shanghai.aliyuncs.com/smartphone705581c6eba7ac8a5d0c5058cc937a9e.wav\",\n" +
                "        \"intent\":{\n" +
                "            \"id\":\"14\",\n" +
                "            \"level\":\"D\",\n" +
                "            \"name\":\"无\"\n" +
                "        },\n" +
                "        \"isExist\":\"true\",\n" +
                "        \"location\":\"北京\",\n" +
                "        \"name\":\"李骏\",\n" +
                "        \"note\":\"256\",\n" +
                "        \"phone\":\"13918686810\",\n" +
                "        \"ringDuration\":0,\n" +
                "        \"salerId\":\"CC_YZS\",\n" +
                "        \"salerName\":\"云知声-管理员\",\n" +
                "        \"sex\":\"MALE\",\n" +
                "        \"tags\":[\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"男\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"性别\",\n" +
                "                \"index\":1,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1002\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"isRequired\":false,\n" +
                "                        \"values\":[\n" +
                "                            {\n" +
                "                                \"name\":\"户外大牌\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"name\":\"户外\",\n" +
                "                        \"index\":0,\n" +
                "                        \"modifiable\":false,\n" +
                "                        \"isRadio\":false,\n" +
                "                        \"key\":\"10\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"isRequired\":false,\n" +
                "                        \"values\":[\n" +
                "                            {\n" +
                "                                \"name\":\"异地渠道\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"name\":\"拓展渠道\",\n" +
                "                        \"index\":5,\n" +
                "                        \"modifiable\":false,\n" +
                "                        \"isRadio\":false,\n" +
                "                        \"key\":\"20\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"isRequired\":false,\n" +
                "                        \"values\":[\n" +
                "                            {\n" +
                "                                \"name\":\"短信\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"name\":\"传统媒体\",\n" +
                "                        \"index\":19,\n" +
                "                        \"modifiable\":false,\n" +
                "                        \"isRadio\":false,\n" +
                "                        \"key\":\"30\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"isRequired\":false,\n" +
                "                        \"values\":[\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\":\"活动\",\n" +
                "                        \"index\":27,\n" +
                "                        \"modifiable\":false,\n" +
                "                        \"isRadio\":false,\n" +
                "                        \"key\":\"40\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"认知渠道\",\n" +
                "                \"index\":2,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":false,\n" +
                "                \"key\":\"1006\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"联排别墅\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"意向业态\",\n" +
                "                \"index\":3,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1009\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"客户组\",\n" +
                "                \"index\":4,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1010\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"意向户型\",\n" +
                "                \"index\":5,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1012\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"品质改善（小区、物业）\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"置业目的\",\n" +
                "                \"index\":6,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1014\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"客户类型\",\n" +
                "                \"index\":7,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1020\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "\n" +
                "                ],\n" +
                "                \"name\":\"关注点\",\n" +
                "                \"index\":8,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":false,\n" +
                "                \"key\":\"1022\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"意向房源\",\n" +
                "                \"index\":9,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1025\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"isRequired\":true,\n" +
                "                \"values\":[\n" +
                "                    {\n" +
                "                        \"name\":\"\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\":\"抗性\",\n" +
                "                \"index\":10,\n" +
                "                \"modifiable\":false,\n" +
                "                \"isRadio\":true,\n" +
                "                \"key\":\"1031\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"uuid\":\"76d0863b5d13a9ed61f7df9149fb93d8\"\n" +
                "    },\n" +
                "    \"head\":\"getFiledRecord\",\n" +
                "    \"merchantId\":\"594EF58BA2464F0880EFE6C0E4F466EC\"\n" +
                "}";

        System.out.println(JSONObject.parseObject(info));





    }
}
