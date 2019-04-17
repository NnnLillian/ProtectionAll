self.SupplyInit = function (name) {
    var url, columns, tableName;
    switch (name) {
        case 'supplyMessage':
            tableName = "NearbySupply-table";
            url = "/GetSupplierMsg?case_position=" + localStorage.getItem("case_position");
            columns = [
                {
                    field: 'supplier_name',
                    title: '公司名称',
                    align: 'center',
                }, {
                    field: 'supplier_head',
                    title: '联系人',
                    align: 'center',
                }, {
                    field: 'supplier_phone',
                    title: '联系方式',
                    align: 'center'
                }, {
                    field: 'position_name',
                    title: '地址',
                    align: 'center'
                }, {
                    field: 'supplier_type_name',
                    title: '资源类型',
                    align: 'center'
                }, {
                    field: 'supplier_type',
                    title: '资源类型ID',
                    visible: false
                }
            ];
            break;
    }
    $('#' + tableName).empty();
    $('#' + tableName).bootstrapTable('destroy').bootstrapTable({
        method: "get",                     //使用get請求到服務器獲取數據
        dataType: "json",
        url: url,
        cache: false,                       // 不緩存
        // contentType: "application/x-www-form-urlencoded",
        contentType: 'application/json,charset=utf-8',
        striped: true,                      // 隔行加亮
        sidePagination: "client",           //分頁方式：client客户端分頁，server服務端分頁（*）
        showColumns: true,                  //是否顯示所有的列
        clickToSelect: true,                //是否啟用點擊選中行
        minimumCountColumns: 2,          //最少允許的列數
        pagination: true,                //是否顯示分頁（*）
        pageNumber: 1,                   //初始化加載第一頁，默認第一頁
        pageSize: 10,                    //每頁的記錄行數（*）
        pageList: [10, 25, 50, 100],     //可供選擇的每頁的行數（*）
        paginationPreText: "<",
        paginationNextText: ">",
        paginationFirstText: "第一页",
        paginationLastText: "最后一页",
        columns: columns,
        onLoadSuccess: function (data) { //加載成功時執行
            console.log(data);
        },
        onLoadError: function (res) { //加載失敗時執行
            console.log(res);
        },

        onCheck: function (row) {  //获取选中行的数据
            console.log("clickrow");
        },

        onCheckAll: function (row) {  //获取全部选择的数据
            console.log("clickall");
            console.log(row);
        },

        onUncheck: function (row) {
            console.log("uncheck");
            console.log(row);
        },

        onUncheckAll: function (row) {
            console.log("uncheckall");
            console.log(row);
        },

        rowStyle: function (row) {
            if (row.supplier_type === 2) {
                return {css: {"background-color": "#e8ffeb63"}}
            } else {
                return {css: {"background-color": "#ffdddf63"}}
            }
        }
    });
};
