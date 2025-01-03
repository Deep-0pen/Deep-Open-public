package AbyssEngine;

public class PlayerStatic extends KIPlayer {
   protected static AEVector3D var_2e9 = new AEVector3D();
   public int posX;
   public int posY;
   public int posZ;

   public PlayerStatic(int var1, AbstractMesh var2, int var3, int var4, int var5) {
      super(var1, -1, new Player(2000.0F, 0, 0, 0, 0), var2, var3, var4, var5);
      this.posX = var3;
      this.posY = var4;
      this.posZ = var5;
   }

   public void update(long var1) {
   }

   public AEVector3D sub_a9(AEVector3D var1) {
      if (this.var_25d == null) {
         var1.set(this.posX, this.posY, this.posZ);
      } else {
         var1.set(this.var_25d.sub_22a(this.var_727));
      }

      return var1;
   }

   public void sub_109doSth() {
      GameStatus.var_8ce.sub_87(this.var_25d);
   }

   public boolean sub_162(int var1, int var2, int var3) {
      return false;
   }
}
