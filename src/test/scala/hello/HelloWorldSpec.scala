package hello

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class HelloWorldSpec extends AnyFreeSpec with ChiselScalatestTester {

  "helloTest" in {
    test(new HelloWorld()) { g =>
      g.io.in.poke(1)
      g.io.out.expect(0)
      g.clock.step()
      g.io.out.expect(1)

      g.io.in.poke(2)
      g.io.out.expect(1)
      g.clock.step()
      g.io.out.expect(2)

      g.io.in.poke(1)
      g.io.out.expect(2)
      g.clock.step()
      g.io.out.expect(1)
    }
  }
}
