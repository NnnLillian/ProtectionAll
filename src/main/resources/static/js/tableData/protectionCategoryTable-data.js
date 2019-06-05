self.categoryDataInit = function (name) {
    let url, columns, tableName, clickToSelect, Request;
    switch (name) {
        case 'teamCategory':
            tableName = "protectCategory-table";
            // local data
            // url = "js/tableData/json/repairCategory.json";

            // 假设 type = protect 为保障组装备，这个Type是武器类型
            url = "/GetPlatoonCategoryMsg/" + localStorage.getItem("scheme_id") + "?type=protect&platoon_id=" + localStorage.getItem("platoon_id");
            clickToSelect = false;
            columns = [
                {
                    checkbox: true,
                    formatter: function (value, row, index) {
                        if (row.category_number === 0) {
                            return {
                                disabled: true,//设置是否不可用
                                checked: false//设置选中
                            }
                        } else {
                            return {
                                disabled: false,
                                checked: false
                            }
                        }
                        return value;
                    }
                }
                ,
                {
                    field: 'category_id',
                    title:
                        '装备ID',
                    align:
                        'center',
                    visible:
                        false
                    // width:300
                }
                ,
                {
                    field: 'category_name',
                    title:
                        '装备名称',
                    align:
                        'center'
                    // sortable:false   //本列不可以排序
                }
                ,
                {
                    field: 'category_model',
                    title:
                        '装备型号',
                    align:
                        'center'
                    // sortable:false   //本列不可以排序
                }
                ,
                {
                    field: 'category_number',
                    title:
                        '装备数目（默认为最大数量）',
                    align:
                        'center',
                    editable:
                        {
                            type: 'number',
                            title:
                                '数量',
                            validate:

                                function (value) {
                                    value = $.trim(value);
                                    if (!value) {
                                        return '不能为空';
                                    } else if (value > Request) {
                                        return '超过已有装备数量';
                                    } else if (value < 0) {
                                        return '装备数量不能为负';
                                    }
                                }

                            ,
                            noeditFormatter: function (value, row, index) {
                                if (value === 0) {
                                    return "0";
                                } else {
                                    return false;
                                }
                            }
                            ,
                        }
                }
            ]
            ;
            break;
    }
    $('#' + tableName).empty();
    $('#' + tableName).bootstrapTable('destroy').bootstrapTable({
        method: "get",                     //使用get請求到服務器獲取數據
        dataType: "json",
        url: url,
        // contentType: "application/x-www-form-urlencoded",
        toolbar: "#toolbar",                //一個jQuery 選擇器，指明自定義的toolbar 例如:#toolbar, .toolbar.
        uniqueId: "id",                    //每一行的唯一標識，一般為主鍵列
        // height: document.body.clientHeight,   //動態獲取高度值，可以使表格自適應頁面
        cache: false,                       // 不緩存
        // url: '../data/.json',   //url一般是請求後台的url地址,調用ajax獲取數據。此處我用本地的json數據來填充表格。
        contentType: 'application/json,charset=utf-8',
        striped: true,                      // 隔行加亮
        sidePagination: "client",           //分頁方式：client客户端分頁，server服務端分頁（*）
        sortable: true,                     //是否啟用排序;意味着整個表格都會排序
        search: true,                       //是否顯示錶格搜索，此搜索是客户端搜索，不會進服務端，所以，個人感覺意義不大
        showColumns: true,                  //是否顯示所有的列
        showRefresh: true,                  //是否顯示刷新按鈕
        showToggle: true,                    //是否顯示詳細視圖和列表視圖
        clickToSelect: clickToSelect,                //是否啟用點擊選中行
        minimumCountColumns: 2,          //最少允許的列數
        pagination: true,                   //是否顯示分頁（*）
        pageNumber: 1,                   //初始化加載第一頁，默認第一頁
        pageSize: 10,                    //每頁的記錄行數（*）
        pageList: [10, 25, 50, 100],     //可供選擇的每頁的行數（*）
        paginationPreText: "<",
        paginationNextText: ">",
        paginationFirstText: "第一页",
        paginationLastText: "最后一页",
        columns: columns,
        onClickCell: function (field, value, row, $element) {
            Request = value;
            // console.log(Request);
        },
        onLoadSuccess: function (data) { //加載成功時執行
            console.log(data);
        },
        onLoadError: function (res) { //加載失敗時執行
            // console.log(res);
        },

        onClickRow: function (row) {  //获取选中行的数据
            console.log("clickrow");
            console.log(row);
        },

        onCheckAll: function (row) {  //获取全部选择的数据
            console.log("clickall");
            console.log(row);
        },

        onUncheck: function (row) {
            console.log("uncheck");
            console.log(row);
        },
        rowStyle: function (row) {
            if (row.category_number === 0) {
                return {css: {"color": "#c30000"}}
            } else {
                return row;
            }
        },
        onUncheckAll: function (row) {
            console.log("uncheckall");
            console.log(row);
        }
    });
}
;

// 保障部队装备的选择
function getCategoryList() {
    return $.map($('#protectCategory-table').bootstrapTable('getSelections'), function (row) {
        let categoryId = row.category_id;
        let categoryCount = row.category_number;
        let selectCategoryNumber = {
            category_id: categoryId,
            category_number: categoryCount
        };
        return selectCategoryNumber
    });
}