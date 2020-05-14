package tech.utils.front;

public class formDataAsmbl2 {

    public String list (int eq_type) {
        String list = "Error in file name";
        if (eq_type == 1){
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"current\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Номинальный ток, А\",\n" +
                    "          \"values\": [\n" +
                    "             100,\n" +
                    "             125,\n" +
                    "             160,\n" +
                    "             200,\n" +
                    "             250,\n" +
                    "             315,\n" +
                    "             400,\n" +
                    "             630,\n" +
                    "\t\t\t 800\n" +
                    "          ]\n" +
                    "       },\n" +
                    "      {\n" +
                    "          \"name\": \"series\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Серия\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"IEK ВА88\",\n" +
                    "                \"value\": \"ВА88\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"ABB Tmax\",\n" +
                    "                \"value\": \"tMAX\"\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "\t   {\n" +
                    "          \"name\": \"bct\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Характеристика\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"C\",\n" +
                    "                \"value\": \"C\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"B\",\n" +
                    "                \"value\": \"B\"\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "\t   {\n" +
                    "          \"name\": \"poles\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Кол-во полюсов\",\n" +
                    "          \"values\": [\n" +
                    "             1,\n" +
                    "             2,\n" +
                    "             3\n" +
                    "             \n" +
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
        else if(eq_type == 4){
            list = "[\n" +
                    "\t{\n" +
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
                    "       {\n" +
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
                    "\t\t\t {\n" +
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
                    "          \"name\": \"tarif\",\n" +
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
        else if (eq_type == 11){
            list = "[\n" +
                    "\t\t\t {\n" +
                    "          \"name\": \"switch_type\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Добавьте тип переключения/АВР\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"механический (вручную рубильники на вводных автоматах)\",\n" +
                    "                \"value\": 1\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"реверсивными рубильниками\",\n" +
                    "                \"value\": 2\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"АВР 2 в 2 (стандартный блок АВР на мотор автоматах)\",\n" +
                    "                \"value\": 3\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       }\n" +
                    "    ]";
        }
        else if (eq_type == 6){
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"current\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Номинальный ток, А\",\n" +
                    "          \"values\": [\n" +
                    "             100,\n" +
                    "             160,\n" +
                    "             200,\n" +
                    "             250,\n" +
                    "             400,\n" +
                    "             630,\n" +
                    "             1000\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"type\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Тип рубильника\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"ВР-32\",\n" +
                    "                \"value\": \"ВР-32\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"РЕ-19\",\n" +
                    "                \"value\": \"РЕ-19\"\n" +
                    "             }\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"handle\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Расположение ручки\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"передняя (в щите)\",\n" +
                    "                \"value\": 1\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"отдельная ручка на каждый полюс\",\n" +
                    "                \"value\": 2\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"боковая (внутри шкафа)\",\n" +
                    "                \"value\": 3\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"боковая (на боку шкафа)\",\n" +
                    "                \"value\": 4\n" +
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
        else if (eq_type == 7){
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"type\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Тип амперметра\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"стрелочный\",\n" +
                    "                \"value\": 1\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"электронный\",\n" +
                    "                \"value\": 2\n" +
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
        else if (eq_type == 8) {
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"type\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Тип вольметра\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"стрелочный\",\n" +
                    "                \"value\": 1\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"электронный\",\n" +
                    "                \"value\": 2\n" +
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
        else if (eq_type == 9){
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"current\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Номинальный ток, А\",\n" +
                    "          \"values\": [\n" +
                    "             50,\n" +
                    "             63,\n" +
                    "             80,\n" +
                    "             100,\n" +
                    "             125,\n" +
                    "             160,\n" +
                    "             200,\n" +
                    "             250,\n" +
                    "\t\t\t 315,\n" +
                    "\t\t\t 400,\n" +
                    "\t\t\t 630,\n" +
                    "\t\t\t 800,\n" +
                    "\t\t\t 1000\n" +
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
        else if (eq_type == 10){
            list = "[\n" +
                    "       {\n" +
                    "          \"name\": \"ip\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Степень защиты, IP\",\n" +
                    "          \"values\": [\n" +
                    "             31,\n" +
                    "             54\n" +
                    "          ]\n" +
                    "       },\n" +
                    "       {\n" +
                    "          \"name\": \"size\",\n" +
                    "          \"type\": \"fieldSelect\",\n" +
                    "          \"title\": \"Размер, ВхШхГ\",\n" +
                    "          \"values\": [\n" +
                    "             {\n" +
                    "                \"name\": \"1800x450x450\",\n" +
                    "                \"value\": \"1800x450x450\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"1800x600x450\",\n" +
                    "                \"value\": \"1800x600x450\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"1800x800x450\",\n" +
                    "                \"value\": \"1800800x450\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"1800x600x600\",\n" +
                    "                \"value\": \"1800x600x600\"\n" +
                    "             },\n" +
                    "             {\n" +
                    "                \"name\": \"1800x800x600\",\n" +
                    "                \"value\": \"1800x800x600\"\n" +
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
        return list;
    }


}
