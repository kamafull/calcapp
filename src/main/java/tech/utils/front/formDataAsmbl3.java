package tech.utils.front;

public class formDataAsmbl3 {


    public String list (int eq_type){
        String list = "Error in file name";
        if (eq_type == 1) {
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"current\",\n" +
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
                    "          \"name\": \"voltage\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Напряжение, В\",\n" +
                    "          \"values\": [\n" +
                    "             230,\n" +
                    "             400\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"mnf\",\n" +
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
                    "          \"name\": \"amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       }\n" +
                    "    ]";
        }
        else if (eq_type == 2){

            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"current\",\n" +
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
                    "          \"name\": \"voltage\",\n" +
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
                    "          \"name\": \"mnf\",\n" +
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
                    "          \"name\": \"series\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Серия\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"ВД1-63 (MDV10)\",\n" +
                    "                \"value\": \"ВД1-63 (MDV10)\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"BasicM (Квартирный)\",\n" +
                    "                \"value\": \"BasicM (Квартирный)\"\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       }\n" +
                    "    ]";

        }

        else if (eq_type == 3){

            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"current\",\n" +
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
                    "          \"name\": \"voltage\",\n" +
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
                    "          \"name\": \"mnf\",\n" +
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
                    "          \"name\": \"series\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Серия\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"АД 12 (MAD10)\",\n" +
                    "                \"value\": \"АД 12 (MAD10)\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"DSH941R\",\n" +
                    "                \"value\": \"DSH941R\"\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       }\n" +
                    "    ]";

        }

        else if (eq_type == 4){

            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"regular\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Список основных счетчиков\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"Меркурий версия 1\",\n" +
                    "                \"value\": 1\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"Меркурий версия 2\",\n" +
                    "                \"value\": 2\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "        {\n" +
            "          \"name\": \"amount\",\n" +
                    "          \"type\": \"fieldInput\",\n" +
                    "          \"title\": \"Количество\",\n" +
                    "          \"value\": \"\"\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"voltage\",\n" +
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
                    "          \"name\": \"mnf\",\n" +
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
                    "          \"name\": \"tariff\",\n" +
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

