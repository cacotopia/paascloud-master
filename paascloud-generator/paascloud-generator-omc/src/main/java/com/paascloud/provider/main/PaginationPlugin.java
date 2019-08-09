//package com.paascloud.provider.main;
//
//import org.mybatis.generator.api.PluginAdapter;
//import org.mybatis.generator.api.ShellRunner;
//
//import java.util.List;
//
///**
// * The class Pagination plugin.
// *
// * @author walkman
// */
//public class PaginationPlugin extends PluginAdapter {
//
//	/**
//	 * Validate boolean.
//	 *
//	 * @param warnings the warnings
//	 *
//	 * @return the boolean
//	 */
//	@Override
//	public boolean validate(List<String> warnings) {
//		return true;
//	}
//
//	private static void generate() {
//		System.out.println("开始生成表结构...");
//		String config = PaginationPlugin.class.getClassLoader().getResource("generator/generatorConfig-B.xml").getFile();
//		String[] arg = {"-configfile", config, "-overwrite"};
//		ShellRunner.main(arg);
//		System.out.println("生成表结构成功...");
//	}
//
//	/**
//	 * The entry point of application.
//	 *
//	 * @param args the input arguments
//	 */
//	public static void main(String[] args) {
//		generate();
//	}
//}