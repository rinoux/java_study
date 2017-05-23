/**
 * Created by rinoux on 2016/11/21.
 */

/**
 * 设置cookie
 * @param name 名称
 * @param value 值
 * @param iDay expire单位：天
 */
function setCookie(name, value, iDay)
{
    var oDate=new Date();
    oDate.setDate(oDate.getDate()+iDay);
    document.cookie=name+'='+value+';expires='+oDate;
}
/**
 * 获取cookie
 * @param name 名称
 * @returns {*} 值
 */
function getCookie(name)
{
    var arr=document.cookie.split('; '); //多个cookie值是以; 分隔的，用split把cookie分割开并赋值给数组
    for(var i=0;i<arr[i].length;i++) //历遍数组
    {
        var arr2=arr[i].split('='); //原来割好的数组是：user=simon，再用split('=')分割成：user simon 这样可以通过arr2[0] arr2[1]来分别获取user和simon
        if(arr2[0]==name) //如果数组的属性名等于传进来的name
        {
            return arr2[1]; //就返回属性名对应的值
        }
        return ''; //没找到就返回空
    }
}
/**
 * 删除cookie
 * @param name 名称
 */
function removeCookie(name)
{
    setCookie(name, 1, -1); //-1就是告诉系统已经过期，系统就会立刻去删除cookie
}


