package AbyssEngine;

import javax.microedition.lcdui.Graphics;

public final class SymbolMapManager_ {
   private static SymbolMap[] symbolMaps;
   private static Graphics graphics;

   public static void sub_58() {
      if (symbolMaps != null) {
         for(int var0 = 0; var0 < symbolMaps.length; ++var0) {
            symbolMaps[var0] = null;
         }

         symbolMaps = null;
      }

      System.gc();
   }

   public static void sub_77(Graphics var0) {
      graphics = var0;
      if (symbolMaps != null) {
         for(int var1 = 0; var1 < symbolMaps.length; ++var1) {
            SymbolMap.setGraphics(graphics);
         }
      }

   }

   public static void addCharMap(String var0, int var1, int var2, int var3) {
      if (graphics != null) {
         if (symbolMaps == null) {
            (symbolMaps = new SymbolMap[1])[0] = new SymbolMap(var0, graphics, var1, 15, 16);
            return;
         }

         SymbolMap[] var4 = new SymbolMap[symbolMaps.length + 1];
         System.arraycopy(symbolMaps, 0, var4, 0, symbolMaps.length);
         var4[symbolMaps.length] = new SymbolMap(var0, graphics, var1, 15, 16);
         symbolMaps = var4;
      }

   }

   public static void setSymMapSetOffsetY(int var0, int var1) {
      if (var1 >= 0 && var1 < symbolMaps.length) {
         symbolMaps[var1].setOffsetY(-2);
      }
   }

   public static void sub_102(String var0, int var1, int var2, int var3) {
      if (var3 >= 0 && var3 < symbolMaps.length) {
         symbolMaps[var3].drawString(var0, var1, var2);
      }
   }

   public static void sub_161(String var0, int var1, int var2, int var3, int var4) {
      if ((var4 & 8) != 0) {
         var1 -= symbolMaps[var3].stringWidth(var0) >> 1;
      }

      if ((var4 & 4) != 0) {
         var2 -= symbolMaps[var3].getHeightMaxRange() >> 1;
      } else if ((var4 & 32) != 0) {
         var2 -= symbolMaps[var3].getHeightMaxRange();
      }

      if ((var4 & 2) != 0) {
         symbolMaps[var3].sub_162(var0, var1, var2);
      } else {
         symbolMaps[var3].drawString(var0, var1, var2);
      }
   }

   public static void sub_185(String[] var0, int var1, int var2, int var3) {
      if (var3 >= 0 && var3 < symbolMaps.length) {
         for(int var4 = 0; var4 < var0.length; ++var4) {
            symbolMaps[var3].drawString(var0[var4], var1, var2 + var4 * sub_2c2());
         }

      }
   }

   public static void sub_1c7(String[] var0, int var1, int var2, int var3, int var4, int var5) {
      if (var3 >= 0 && var3 < symbolMaps.length) {
         var5 = var5 > 0 ? var5 / sub_2c2() + 1 : 0;

         for(int var6 = 0; var6 < var0.length; ++var6) {
            int var7 = var6 < var5 ? var1 + var4 : var1;
            symbolMaps[var3].drawString(var0[var6], var7, var2 + var6 * sub_2c2());
         }

      }
   }

   public static void sub_22a(String[] var0, int var1, int var2, int var3, int var4) {
      int var5 = sub_2c2();
      if (var3 >= 0 && var3 < symbolMaps.length) {
         int var6 = 0;

         for(int var7 = 0; var7 < var0.length; ++var7) {
            if ((var4 & 8) != 0) {
               var6 = -(symbolMaps[var3].stringWidth(var0[var7]) >> 1);
            }

            if ((var4 & 2) != 0) {
               symbolMaps[var3].sub_162(var0[var7], var1, var2 + var7 * var5);
            } else {
               symbolMaps[var3].drawString(var0[var7], var1 + var6, var2 + var7 * var5);
            }
         }

      }
   }

   public static int sub_250(String var0) {
      return sub_25b(var0, 0);
   }

   public static int sub_25b(String var0, int var1) {
      return var1 >= 0 && var1 < symbolMaps.length ? symbolMaps[var1].stringWidth(var0) : 0;
   }

   public static void setPrimarySymMapSpacing(int var0) {
      symbolMaps[0].setSpacing(0);
   }

   public static void setSymMapSpacing(int var0, int var1) {
      if (var1 >= 0 && var1 < symbolMaps.length) {
         symbolMaps[var1].setSpacing(0);
      }
   }

   public static int sub_2c2() {
      return symbolMaps[0].getHeightMaxRange();
   }

   public static int sub_31c(String[] var0) {
      return var0.length * symbolMaps[0].getHeightMaxRange();
   }

   public static void setPrimarySymMapHeightMaxRange(int var0) {
      symbolMaps[0].setHeightMaxRange(11);
   }

   public static void setSymHeightMaxRange(int var0, int var1) {
      if (var1 >= 0 && var1 < symbolMaps.length) {
         symbolMaps[var1].setHeightMaxRange(11);
      }
   }

   public static String[] sub_3a1(String var0, int var1, int var2, int var3, int var4) {
      int var5 = 0;
      int var6 = 0;
      String var7 = null;
      var0 = var0 + "\n";

      for(var4 = var4 > 0 ? var4 / sub_2c2() + 1 : 0; var6 < var0.length(); var6 += var7.length()) {
         int var12 = var5 < var4 ? var1 - var3 : var1;
         var7 = sub_3f2(var0.substring(var6, var0.length()), var12, var2, false);
         ++var5;
      }

      String[] var13 = new String[var5];
      var6 = 0;

      for(int var8 = 0; var8 < var5; ++var8) {
         int var9 = var8 < var4 ? var1 - var3 : var1;
         var13[var8] = sub_3f2(var0.substring(var6, var0.length()), var9, var2, false);
         var6 += var13[var8].length();
         var13[var8].trim();
      }

      return var13;
   }

   public static String[] sub_3b2(String var0, int var1) {
      byte var2 = 0;
      var1 = var1;
      int var3 = 0;
      int var4 = 0;
      String var5 = null;

      for(var0 = var0 + "\n"; var4 < var0.length(); var4 += var5.length()) {
         var5 = sub_3f2(var0.substring(var4, var0.length()), var1, var2, false);
         ++var3;
      }

      String[] var10 = new String[var3];
      var4 = 0;

      for(int var6 = 0; var6 < var3; ++var6) {
         var10[var6] = sub_3f2(var0.substring(var4, var0.length()), var1, var2, false);
         var4 += var10[var6].length();
         var10[var6].trim();
      }

      return var10;
   }

   public static String sub_3f2(String var0, int var1, int var2, boolean var3) {
      int var4 = 0;
      int var5 = (var2 >= 0 && var2 < symbolMaps.length ? symbolMaps[var2].getTileHeight() : 0) >> 1;

      for(int var6 = 0; var6 < var0.length(); ++var6) {
         if (var3 || var0.charAt(var6) == ' ' || var0.charAt(var6) == '\n' || var0.charAt(var6) == '\r') {
            var4 = var6;
         }

         int var8 = var6 + 1;
         if ((var5 += symbolMaps[var2].subStringWidth(var0, var6, var8)) >= var1) {
            if (0 < var4) {
               return var0.substring(0, var4 + 1);
            }

            return var0.substring(0, var6 + 1);
         }

         if (var0.charAt(var6) == '\n' || var0.charAt(var6) == '\r') {
            return var0.charAt(var6) == '\n' ? var0.substring(0, var6 + 1).replace('\n', ' ') : var0.substring(0, var6 + 1).replace('\r', ' ');
         }
      }

      if (0 < var0.length() - 1) {
         return var0.substring(0, var0.length());
      } else {
         return "";
      }
   }
}
