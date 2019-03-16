self.applicationTableInit = function (name) {
    // var tableName
    // switch (name) {
    //     case 'repair':
    //         //
    //
    //         break;
    //     case 'spare':
    //         //省略
    //         break;
    // }
    $('.'+name).load("applicationTable/"+ name +".html")
};
