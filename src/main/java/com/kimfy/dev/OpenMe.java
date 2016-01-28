package com.kimfy.dev;

/**
 * The purpose of this class is to make ForgeGradle shut the fuck up about this error:
 * '''
 * Cannot expand ZIP '..\retromapping\retromappedReplacedMain.jar' as it does not exist.
 * '''
 *
 * when building. If the src\main\java folder is not present with a package and class
 * inside it - gradle will fail the build for a reason I don't have any knowledge in.<br>
 * ------------------------------------------------------------------------------------------------------- <br>
 * <i>This is a ForgeGradle issue I believe. Groovy isn't supported by default afaik</i><br>
 * -------------------------------------------------------------------------------------------------------<br>
 * However, with this we can happily continue coding in groovy. There might of course be other issues I've
 * overlooked of course. At least the project <i>should</i> build now!
 * I'll try to keep this updated the more I do Groovy
 * @author kimfy
 */
public class OpenMe
{
}