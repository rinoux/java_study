/**
 * Created by rinoux on 2017/2/15.
 */

/**
 * 清除所有空白字符
 *
 * @param element 待清除空白字符的元素
 */
function cleanWhiteSpace(element) {
    element = element || document;//若element为空，则默认清除整个文档的空白字符

    var cursor = element.firstChild;//定义游标为第一个子节点作为起始位置

    while (cursor != null) {
        //如果该节点是一个文本节点，且只包含空白字符
        if (cursor.nodeType == 3 && ! /\S\.test(cursor.nodeValue)) {
            // 注意"/\S\.test"是正则测试是否全为空白，返回bool
            //删除该节点
            element.removeChild(cursor);
        } else if (cursor.nodeType == 1) {//如果该节点是一个元素，递归
            cleanWhiteSpace(cursor);
        }
        cursor = cursor.nextSibling;//删除空白后，游标移至下个兄弟节点
    }
}