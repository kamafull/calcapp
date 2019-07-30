package tech.utils.front;

public class formDataAsmbl3 {


    public String list (int eq_type){
        String list = "Error in file name";
        if (eq_type == 1) {
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"cb_current\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Номинальный ток, А\",\n" +
                    "          \"values\": [\n" +
                    "             6,\n" +
                    "             10,\n" +
                    "             16,\n" +
                    "             20,\n" +
                    "             25,\n" +
                    "             32,\n" +
                    "             40,\n" +
                    "             50\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"cb_voltage\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Напряжение, В\",\n" +
                    "          \"values\": [\n" +
                    "             230,\n" +
                    "             400\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"cb_mnf\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Производитель\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"IEK\",\n" +
                    "                \"value\": 3\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"ABB\",\n" +
                    "                \"value\": 6\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"cb_series\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Серия\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"Квартирная серия ВА47-29\",\n" +
                    "                \"value\": 0\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"Квартирная серия SH200\",\n" +
                    "                \"value\": 1\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"cb_amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       }\n" +
                    "    ]";
        }
        else if (eq_type == 2){

            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"uzo_current\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Номинальный ток, А\",\n" +
                    "          \"values\": [\n" +
                    "             16,\n" +
                    "             20,\n" +
                    "             25,\n" +
                    "             32,\n" +
                    "             40,\n" +
                    "             50,\n" +
                    "             63\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"uzo_voltage\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Напряжение, В\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"2х полюсное (230 В)\",\n" +
                    "                \"value\": 230\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"4х полюсное (400 В)\",\n" +
                    "                \"value\": 400\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"uzo_mnf\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Производитель\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"IEK\",\n" +
                    "                \"value\": 3\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"ABB\",\n" +
                    "                \"value\": 6\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"uzo_series\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Серия\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"ВД1-63\",\n" +
                    "                \"value\": 0\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"BasicM\",\n" +
                    "                \"value\": 1\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"uzo_amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       }\n" +
                    "    ]";

        }

        else if (eq_type == 3){

            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"difcb_current\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Номинальный ток, А\",\n" +
                    "          \"values\": [\n" +
                    "             6,\n" +
                    "             10,\n" +
                    "             16,\n" +
                    "             20,\n" +
                    "             25,\n" +
                    "             32,\n" +
                    "             40,\n" +
                    "             50,\n" +
                    "             63\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"difcb_voltage\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Напряжение, В\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"2х полюсное (230 В)\",\n" +
                    "                \"value\": 230\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"4х полюсное (400 В)\",\n" +
                    "                \"value\": 400\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"difcb_mnf\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Производитель\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"IEK\",\n" +
                    "                \"value\": 3\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"ABB\",\n" +
                    "                \"value\": 6\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"difcb_series\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Серия\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"АД12\",\n" +
                    "                \"value\": 0\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"BasicM\",\n" +
                    "                \"value\": 1\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"difcb_amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       }\n" +
                    "    ]";

        }

        else if (eq_type == 4){

            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"pmeter_voltage\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Напряжение\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"Однофазный\",\n" +
                    "                \"value\": 230\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"Трехфазный\",\n" +
                    "                \"value\": 400\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"pmeter_mnf\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Производитель\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"Ленэлектро\",\n" +
                    "                \"value\": 84\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"Инкотекс (Меркурий)\",\n" +
                    "                \"value\": 82\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"ЛЭМЗ\",\n" +
                    "                \"value\": 85\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"pmeter_tarif\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Тариф\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"Однотарифный\",\n" +
                    "                \"value\": 1\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"многотарифный\",\n" +
                    "                \"value\": 2\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"pmeter_amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       }\n" +
                    "    ]";

        }
        else if (eq_type == 5){

            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"ecs_apart\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Укажите параметры корпуса шкафа\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"Щит  мет. ЩМП-250х300х140 EKF (ЩМП-02) IP31\",\n" +
                    "                \"value\": 1\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"Щит мет. ЩРУВ 12 мод. с окном IP31 (440Х340Х140) EKF\",\n" +
                    "                \"value\": 2\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"Щит мет. ЩМП-400Х400Х150 EKF(ЩМП-05) IP31\",\n" +
                    "                \"value\": 3\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       }\n" +
                    "    ]";

        }

        return list;



    }



}
