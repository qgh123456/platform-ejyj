package com.atqgh.common.utils;

import java.util.List;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.ObjectUtils;

/**
 * 树工具类.
 *
 * @author qiguohui
 * @create 2022/5/06 15:55
 */
public class TreeUtil {

    public static final String ROOTELE = "/";

    /**
     * 生成树.
     * @param preTree 集合
     * @return 树
     */
    public static List<? extends BaseTree> buildTree(List<? extends BaseTree> preTree) {
        return buildTree(preTree, ROOTELE);
    }

    /**
     * 生成树.
     *
     * @param preTree 集合
     * @param rootEle 根节点编码
     * @return 树
     */
    public static List<? extends BaseTree> buildTree(List<? extends BaseTree> preTree, String rootEle) {

        List<BaseTree> tree = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(preTree)) {
            preTree.forEach(var1 -> {
                if (ObjectUtils.isNotEmpty(var1) && rootEle.equals(var1.getPcode())) {
                    tree.add(var1);
                }
                preTree.forEach(var2 -> {
                    // 找儿子
                    if (ObjectUtils.isNotEmpty(var2) && ObjectUtils.isNotEmpty(var1)
                            && ObjectUtils.isNotEmpty(var1.getCode())
                            && var1.getCode().equals(var2.getPcode())) {
                        List<BaseTree> children = var1.getChildren();
                        if (ObjectUtils.isEmpty(children)) {
                            children = Lists.newArrayList();
                            var1.setChildren(children);
                        }
                        children.add(var2);
                    }
                });
            });
        }
        return tree;
    }
}
